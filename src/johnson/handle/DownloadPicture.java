package johnson.handle;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class DownloadPicture {
	
	private static File directory = new File("upload");
	
	private final static String DELIMITER = ";";

	public DownloadPicture() {
		// TODO Auto-generated constructor stub
	}
	
	public static String handle(File file) {
		if (file == null) {
			return "please select a excel file to process";
		}
		if (!file.canRead() || !file.canWrite()) {
			return "permission deny";
		}	
		int result;
		if (file.getName().indexOf(".csv") >= 0) {
			result = handleCSV(file);
		} else {
			result = handleXLS(file);
		}
		if (result != 0) {
			return "process fail";
		}
		return "process success";
	}
	
	protected static int handleXLS(File file) {
		try {
			Workbook wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			int colCount = sheet.getColumns();
			int rowCount = sheet.getRows();
			if (rowCount <= 1) {
				return 0;
			}
			String[][] content = new String[rowCount][colCount];
			int imgPosition = 0;
			for (int i = 0; i < rowCount; i ++) {
				for (int j = 0; j < colCount; j ++) {
					content[i][j] = sheet.getCell(j, i).getContents();
					if (i == 0 && content[i][j].indexOf("图片") >= 0) {
						imgPosition = j;
					}
				}
			}
			if (!directory.exists()) {
				directory.mkdirs();
			}
			for (int i = 1; i < rowCount; i ++) {
				String[] imgURLs = content[i][imgPosition].split(DELIMITER);
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < imgURLs.length; j++) {
					sb.append(inputOutput(imgURLs[j])+DELIMITER);
				}
				content[i][imgPosition] = sb.substring(0, sb.length()-1).toString();
			}
			writeNew(file.getName(), content);
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	protected static int handleCSV(File file) {
		try {
			Reader in = new FileReader(file);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			int imgPosition = -1;
			for (CSVRecord record : records) {
				if (imgPosition == -1) {
					for (int i = 0; i < record.size(); i ++) {
						if (record.get(i).indexOf("图片") >= 0) {
							imgPosition = i;
						}
					}
				} else {
					String imgName = inputOutput(record.get(imgPosition));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}
	
	protected static String inputOutput(String imgURL) {
		HttpURLConnection httpConn;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		File imgFile = null;
		byte[] buffer = new byte[1024];
		try {
			httpConn = (HttpURLConnection) (new URL(imgURL)).openConnection();
			httpConn.setRequestMethod("GET");
			httpConn.connect();
			int stateCode = httpConn.getResponseCode();
			if (stateCode == HttpURLConnection.HTTP_OK) {
				String mimeType = httpConn.getContentType();
				String[] mimeTypes = mimeType.split("/");
				imgFile = new File(directory.getName()+File.separator+UUID.randomUUID().toString()+"."+mimeTypes[mimeTypes.length-1]);
				bis = new BufferedInputStream(httpConn.getInputStream());
				bos = new BufferedOutputStream(new FileOutputStream(imgFile));
	            int len = -1;
	            while ((len = bis.read(buffer)) != -1) {
	                bos.write(buffer, 0, len);
	                bos.flush();
	            }
			}
			httpConn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgFile.getName();
	}
	
	protected static void writeNew(String fileName, String[][] content) throws FileNotFoundException {
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File("new_"+fileName)));
		int rowCount = content.length;
		int colCount = content[0].length;
		try {
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			for (int i = 0; i < rowCount; i ++) {
				for (int j = 0; j < colCount; j ++) {
					Label cell = new Label(j, i, content[i][j]);
					ws.addCell(cell);
				}
			}
			wwb.write();
			wwb.close();
			os.flush();
			os.close();
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
	}

}
