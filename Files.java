package de.zeroco.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.opencsv.CSVWriter;

import de.zeroco.util.Utility;

public class Files {
	public static void main(String[] args) throws Exception {
		String [] firstSet = {"Name", "RollNumber"};
		String [] secondSet = {"Ravi", "202227"};
		String [] thirdSet = {"Name", "202224"};
		List<String[]> list = new ArrayList<String[]>();
		list.add(firstSet);
		list.add(secondSet);
		list.add(thirdSet);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("one", "ram");
		map.put("two", "sam");
		List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> firstRow = new HashMap<>();
        firstRow.put("Name", "John Doe");
        firstRow.put("Age", 30);
        firstRow.put("City", "New York");
        data.add(firstRow);
        Map<String, Object> secondRow = new HashMap<>();
        secondRow.put("Name", "Jane Smith");
        secondRow.put("Age", 25);
        secondRow.put("City", "London");
        data.add(secondRow);
        Map<String, Object> thirdRow = new HashMap<>();
        thirdRow.put("Name", "Bob Johnson");
        thirdRow.put("Age", 35);
        thirdRow.put("City", "Paris");
        data.add(thirdRow);
        File file = new File("C:\\Users\\91834\\Desktop\\Eclipse.txt");
        file.getName().equalsIgnoreCase("Eclipse.txt");
//        System.out.println(file.isDirectory());
//		JSONObject object = new JSONObject();
//		object.put("Name", "Ram");
//		object.put("RollNumber", "18481A0334");
//		object.put("Place", "Madhapur");
		
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").canExecute());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").canRead());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").canWrite());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").isHidden());
//		System.out.println(Arrays.toString(new File("C:\\Users\\91834\\Desktop\\files\\").list()));
//		System.out.println(Arrays.toString(new File("C:\\Users\\91834\\Desktop\\files\\").listFiles()));
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").isFile());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\").isDirectory());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getAbsoluteFile());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getAbsolutePath());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getCanonicalFile());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getCanonicalPath());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getFreeSpace());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getName());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").lastModified());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").length());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getTotalSpace());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").getUsableSpace());
//		System.out.println(new File("C:\\Users\\91834\\Desktop\\files\\Java.txt").isAbsolute());
//		System.out.println(Arrays.toString(new File("C:\\Users\\91834\\Desktop\\files\\").listRoots()));
//		System.out.println(createFile("C:\\Users\\91834\\Desktop\\Sample\\filess.xlsx"));
//		System.out.println(deleteFile("C:\\Users\\91834\\Desktop\\files\\Java.txt"));
//		System.out.println(isExists("C:\\Users\\91834\\Desktop\\files\\"));
//		System.out.println(getParentPath("C:\\Users\\91834\\Desktop\\files\\Java.txt"));
//		System.out.println(createFolder("C:\\Users\\91834\\Desktop\\files\\Test\\"));
//		System.out.println(readDataInFile("C:\\Users\\91834\\Desktop\\files\\Java.txt"));
//		System.out.println(readDataInFile("C:\\Users\\91834\\Desktop\\files\\Book1.csv"));
//		System.out.println(readDataInFile("C:\\Users\\91834\\Desktop\\files\\New document 1.json"));
//		System.out.println(getNumberOfLinesInFile("C:\\Users\\91834\\Desktop\\files\\Java.txt"));
//		System.out.println(getLengthyLineInFile("C:\\Users\\91834\\Desktop\\files\\Java.txt"));
//		System.out.println(writeDataInCSV("C:\\Users\\91834\\Desktop\\files\\Book1.csv", list));
//		System.out.println(readExcelFile("C:\\Users\\91834\\Desktop\\files\\Book1.xlsx"));
//		System.out.println(writeDataInExcel("C:\\Users\\91834\\Desktop\\files\\Book1.xlsx", list));
//		System.out.println(writeDataInJSON("C:\\Users\\91834\\Desktop\\files\\New document 1.json", object));
//		System.out.println(appendDataInTextFile("C:\\Users\\91834\\Desktop\\files\\Java.txt", 11, "Welcome", "Hello World", false));
//		System.out.println(appendDataInTextFile("C:\\Users\\91834\\Desktop\\files\\Java.txt", 5, "Good Bye", false));
//		System.out.println(appendDataInTextFile("C:\\Users\\91834\\Desktop\\files\\Java.txt", "Welcome Java", true));
//		System.out.println(MapToJson("C:\\Users\\91834\\Desktop\\files\\Sample.json", map));
//		System.out.println(getReadDataInPdfFile("C:\\Users\\91834\\Downloads\\sodapdf-converted.pdf"));
//		System.out.println(writeDataInPdfFile("C:\\Users\\91834\\Desktop\\Sample\\file.pdf", "Hello world, the worls is so beautiful"));
//		System.out.println(writeDataInExcel("C:\\Users\\91834\\Desktop\\Sample\\filess.xlsx", data, "ZeroCode"));
//        System.out.println(readDataInCsvFile("C:\\Users\\91834\\Downloads\\Master_Pincode_data.csv"));
//        System.out.println(createFile("C:\\Users\\91834\\Desktop\\Sample\\sample.json"));
//        System.out.println(readDataInJson("C:\\Users\\91834\\Desktop\\Sample\\sample.json"));
        System.out.println(readExcelFile("C:\\Users\\91834\\Downloads\\BRDVillageList.xlsx"));
	}

	public static String createFile(String filePath) {
		if (Utility.isBlank(filePath) || isExists(filePath)) return null;
		String result = "";
		File file = new File(filePath);
		try {
			result = file.createNewFile() ? "New File is created!" : "File already exists.";
		} catch (IOException e) {
			result = "Add the file name";
		}
		return result;
	}
	
//	public static String setPositionOfData(String position, int lineNumber, String line, String data) {
//	if (position != "") {
//		int index = line.indexOf(position);
//		if (index != -1) {
//			while (index != -1) {
//				StringBuilder sb = new StringBuilder(line);
//				sb.insert(index + position.length(), " " + data);
//				index = line.indexOf(position, index + position.length() + data.length() + 1);
//			}
//			return line;
//		} else {
//			StringBuilder sb = new StringBuilder(line);
//			line = sb.append(" " + data).toString();
//			return line;
//		}
//	} else {
//		list.add(lineNumber - 1, data);
//	}
//	return null;
//}
	public static String deleteFile(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		File file = new File(filePath);
		String result = file.delete() ? "File deleted" : "File Not Exists";
		return result;
	}
	
	public static boolean isExists(String filePath) {
		if (Utility.isBlank(filePath)) return false;
		File file = new File(filePath);
		return file.exists();
	}
	
	public static String getParentPath(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		File file = new File(filePath);
		return file.getParent();
	}
	
	public static boolean createFolder(String filePath) {
		if (Utility.isBlank(filePath) || isExists(filePath)) return false;
		File file = new File(filePath);
		return file.mkdirs();
	}
	
	public static List<String> readDataInFile(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		List<String> list = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			for (String value = bufferedReader.readLine(); value != null; value = bufferedReader.readLine()) {
				list.add(value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static String writeDataInFile(String filePath, List<String> list) {
		if (Utility.isBlank(filePath) || Utility.isBlank(list)) return null;
		if (isExists(filePath)) {
			createFile(filePath);
		}
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(filePath));
			for (String updatedLine : list) {
                bufferedWriter.write(updatedLine);
                bufferedWriter.newLine();
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	public static int getNumberOfLinesInFile(String filePath) {
		if (Utility.isBlank(filePath)) return 0;
		int count = 0;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			for (String value = bufferedReader.readLine(); value != null; value = bufferedReader.readLine()) {
				count++;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public static String getLengthyLineInFile(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		String line = "";
		int maxLength = 0;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			for (String value = bufferedReader.readLine(); value != null; value = bufferedReader.readLine()) {
				if (value.length() > maxLength) {
					line = value;
					maxLength = value.length();
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return line;
	}
	
	public static String readExcelFile(String filePath) {
		if (Utility.isBlank(filePath) || !isExists(filePath)) return null;
		String cellValue = "";
		XSSFWorkbook workBook = null;
		try {
			workBook = new XSSFWorkbook(new FileInputStream(filePath));
			XSSFSheet sheet = workBook.getSheetAt(0);
			for (Row row : sheet) {
                for (Cell cell : row) {
                    cellValue = cellValue + cell.getStringCellValue() + "\t";
                }
                cellValue = cellValue + "\n";
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cellValue;
	}
	
	public static String writeDataInExcel(String filePath, List<Map<String, Object>> list, String sheetName) {
		if (Utility.isBlank(filePath) || Utility.isBlank(list)) return null;
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet(sheetName);
		int rowNum = 0;
		for (Map<String, Object> rowData : list) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (String field : rowData.keySet()) {
				Cell cell = row.createCell(colNum++);
				Object value = rowData.get(field);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
			}
		}
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			workBook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	public static String writeDataInCSV(String filePath, List<String[]> data) {
		if (Utility.isBlank(filePath) || Utility.isBlank(data) || !isExists(filePath)) return null;
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(filePath));
			writer.writeAll(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	public static String writeDataInJSON(String filePath, String data) {
		if (Utility.isBlank(filePath)) return null;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			fileWriter.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	public static String appendDataInTextFile(String filePath, int lineNumber, String precedingTerm, String data, boolean restoreFlag) {
		if (Utility.isBlank(filePath) || Utility.isBlank(data)) return null;
		if (restoreFlag) {
			filePath = clearExistDataInFile(filePath);
		}
		if (isFileEmpty(filePath) || lineNumber > getNumberOfLinesInFile(filePath)) {
			lineNumber = 0;
		}
		List<String> list = Files.readDataInFile(filePath);
		if (lineNumber > 0) {
			if (precedingTerm != "") {
				String line = list.remove(lineNumber - 1);
				int index = line.indexOf(precedingTerm);
				if (index != -1) {
					StringBuilder sb = new StringBuilder(line);
					sb.insert(index + precedingTerm.length(), " " + data);
					line = sb.toString();
					list.add(lineNumber - 1, line);
				} else {
					StringBuilder sb = new StringBuilder(line);
					line = sb.append(" " + data).toString();
					list.add(lineNumber - 1, line);
				}
			} else {
				list.add(lineNumber - 1, data);
			}
		} else {
			list.add(data);
		}
		Files.writeDataInFile(filePath, list);
		return filePath;
	}
	
	public static String appendDataInTextFile(String filePath, String data, boolean restoreFlag) {
		return appendDataInTextFile(filePath, 0, data, "", restoreFlag);
	}
	
	public static String appendDataInTextFile(String filePath,int lineNumber, String data, boolean restoreFlag) {
		return appendDataInTextFile(filePath, lineNumber, "", data, restoreFlag);
	}
	
	public static boolean isFileEmpty(String filePath) {
		boolean status = false;
		File file = new File(filePath);
		if (file.length() == 0) {
			status = true;
		}
		return status;
	}
	
	public static String clearExistDataInFile(String filePath) {
		FileOutputStream outputStream = null;
		try {
            outputStream = new FileOutputStream(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		return filePath;
	}
	
	public static String MapToJson(String filePath, Map<String, Object> map) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(filePath), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public static String getReadDataInPdfFile(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		PdfReader reader = null;
		String text = "";
		try {
			reader = new PdfReader(new File(filePath).getAbsolutePath());
			int numPages = reader.getNumberOfPages();
			for (int pageNum = 1; pageNum <= numPages; pageNum++) {
				text = text + PdfTextExtractor.getTextFromPage(reader, pageNum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return text;
	}
	
	public static String writeDataInPdfFile(String filePath, String data) {
		if (Utility.isBlank(filePath) || Utility.isBlank(data)) return null;
		Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            Paragraph paragraph = new Paragraph(data);
            document.add(paragraph);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	document.close();
        }
		return filePath;
	}
	
	public static String readDataInCsvFile(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		String list = "";
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			for (String value = bufferedReader.readLine(); value != null; value = bufferedReader.readLine()) {
				list = list + value + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static String readDataInJson(String filePath) {
		if (Utility.isBlank(filePath)) return null;
		String data = "";
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			for (String value = bufferedReader.readLine(); value != null; value = bufferedReader.readLine()) {
				data = data + value + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
