package com.common.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
 
/**
 * excel工具类
 * 支持2003、2007、2010、2013
 * @author liubenlong
 *
 */
public class ExcelUtil {
     
  private Workbook wb = null;
  private Sheet sheet = null;
  
  /**
   * 模版文件路径
   */
  private String templateFilePath;
  /**
   * 总行数
   * 最大行的index值，实际行数要加1 
   */
  private int rowNum = 0;
  /**
   * 总列数
   */
  private int columnNum = 0;
   
   
   
  /**
   * 初始化
   * @param filePath
   * @param sheetIndex
   * <p>默认第一个sheet</p>
   */
  public ExcelUtil(String filePath,int sheetIndex){
    try {
      InputStream inp = new FileInputStream(filePath);
      wb = WorkbookFactory.create(inp);
       
      this.sheet = wb.getSheetAt(sheetIndex);
 
      rowNum = sheet.getLastRowNum();
 
      if(sheet.getRow(0)!=null){
          columnNum = sheet.getRow(0).getLastCellNum();
      }
       
      System.out.println("第"+sheetIndex+"个工作薄；总行数："+rowNum+"；总列数："+columnNum);
       
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  /**
   * 初始化
   * @param filePath
   * @param sheetIndex
   * <p>默认第一个sheet</p>
   */
  public ExcelUtil(InputStream  is,int sheetIndex){
    try {
      InputStream inp = is;
      wb = WorkbookFactory.create(inp);
       
      this.sheet = wb.getSheetAt(sheetIndex);
 
      rowNum = sheet.getLastRowNum();
 
      if(sheet.getRow(0)!=null){
          columnNum = sheet.getRow(0).getLastCellNum();
      }
       
      System.out.println("第"+sheetIndex+"个工作薄；总行数："+rowNum+"；总列数："+columnNum);
       
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
   
   
  public ExcelUtil(){
       
  }
   
       
 /**
   * 取Excel所有数据，包含header
   * @return  List<String[]>
   */
 public List<String[]> getAllData(){
    List<String[]> dataList = new ArrayList<String[]>();
    if(columnNum>0){
        for(int i = 0;i<rowNum+1;i++){
            String[] singleRow = new String[columnNum];
            for(int j=0;j<columnNum;j++){
                singleRow[j] = getCellVal(i,j);
            }
            dataList.add(singleRow);
        }
    }
    return dataList;
  }
  
     /**
      * 获取单元格数据
      * @param columnNum
      * <P>从0开始</P>
      * @param row
      * <P>从0开始</P>
      * @return
      */
     public String getCellVal(int rowNum, int columnNum){
          
         String cellVal = null;
         Cell cell = sheet.getRow(rowNum).getCell(columnNum, Row.CREATE_NULL_AS_BLANK);
         switch(cell.getCellType()){
            case Cell.CELL_TYPE_BLANK:
                cellVal = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellVal = Boolean.toString(cell.getBooleanCellValue());
                break;
                //数值
            case Cell.CELL_TYPE_NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    cellVal = String.valueOf(cell.getDateCellValue());
                    double d = cell.getNumericCellValue();
                    Date date = HSSFDateUtil.getJavaDate(d);
                    SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    cellVal = sFormat.format(date);
                }else{
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String temp = cell.getStringCellValue();
                    //判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                    if(temp.indexOf(".")>-1){
                        cellVal = String.valueOf(new Double(temp)).trim();
                    }else{
                        cellVal = temp.trim();
                    }
                }
                break;
            case Cell.CELL_TYPE_STRING:
                cellVal = cell.getStringCellValue().trim();
                break;
            case Cell.CELL_TYPE_ERROR:
                cellVal = "";
                break;  
            case Cell.CELL_TYPE_FORMULA:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cellVal = cell.getStringCellValue();
                if(cellVal!=null){
                    cellVal = cellVal.replaceAll("#N/A","").trim();
                }
                break;
            default:
                cellVal = "";
                break;
         }
         return cellVal;
     }
      
     /**
      * 设置单元格数据
      * 下标从0开使
      * @param rownum
      * @param column
      * @param value
      */
     public void setCellVal(int rownum,int column,String value){
         sheet.getRow(rownum).getCell(column).setCellValue(value);
     }
      
     /**
      * 保存修改后的 文件
      * @param newFilePath
      * <P>文件绝对路径</P>
     * @throws IOException 
      */
     public void  saveNewFile(String newFilePath) throws IOException{
         FileOutputStream out=new FileOutputStream(newFilePath); 
         out.flush(); 
         wb.write(out);
         out.close(); 
     }
      
  
  /**
   * 获取某一行数据
   * @param rowIndex 计数从0开始，rowIndex为0代表header行
   * @return
   */
    public String[] getRowData(int rowIndex){
        String[] dataArray = null;
		if (rowIndex > this.rowNum) {
            return dataArray;
        }else{
            String[] singleRow = new String[columnNum];
            for(int j=0;j<columnNum;j++){
                singleRow[j] = getCellVal(rowIndex,j);
            }
            return singleRow;
        }
    }
   
  /**
   * 获取某一列数据
   * @param colIndex
   * @return
   */
      public String[] getColumnData(int columnIndex){
        String[] dataArray = new String[rowNum+1];
        if(columnIndex>columnNum){
          return dataArray;
        }else{
            for(int i = 0;i<rowNum+1;i++){
                dataArray[i] = getCellVal(i,columnIndex);
            }
        }
        return dataArray;
      }
       
       
       
      /**
         * 目前只支持一行表头的Excel
         * @param headList
         * @param headstyle
         * @param bodyList
         * @param bodystyle
         * @throws IOException
         */
        @Deprecated
        public void create2007(String filePath,List<String> headList,HSSFCellStyle headstyle,List<String[]> bodyList,HSSFCellStyle bodystyle) throws IOException{
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
             
            XSSFRow headRow = sheet.createRow(0);
            for (int  i =0 ;i<headList.size();i++) {
                XSSFCell cell = headRow.createCell(i);
                cell.setCellValue(headList.get(i));
                if(null != headstyle)cell.setCellStyle(headstyle);
            }
             
            for (int  i = 1 ;i<bodyList.size()+1;i++) {
                XSSFRow row = sheet.createRow(i);
                for(int  j = 0 ;j<bodyList.get(i-1).length;j++){
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(bodyList.get(i-1)[j]);
                    if(null != bodystyle)cell.setCellStyle(bodystyle);
                }
            }
             
             
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
             
        }
         
        /**
         * 目前只支持一行表头的Excel
         * @param headList
         * @param headstyle
         * @param bodyList
         * @param bodystyle
         * @throws IOException
         */
        @Deprecated
        public void create2003(String filePath,List<String> headList,HSSFCellStyle headstyle,List<String[]> bodyList,HSSFCellStyle bodystyle) throws IOException{
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet();
             
            HSSFRow headRow = sheet.createRow(0);
             
             
            for (int  i =0 ;i<headList.size();i++) {
                HSSFCell cell = headRow.createCell(i);
                cell.setCellValue(headList.get(i));
                if(null != headstyle)cell.setCellStyle(headstyle);
            }
             
            for (int  i = 1 ;i<bodyList.size()+1;i++) {
                HSSFRow row = sheet.createRow(i);
                for(int  j = 0 ;j<bodyList.get(i-1).length;j++){
                    HSSFCell cell = row.createCell(j);
                    cell.setCellValue(bodyList.get(i-1)[j]);
                    if(null != bodystyle)cell.setCellStyle(bodystyle);
                }
            }
             
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
        }
         
         
         
      public Workbook getWb() {
            return wb;
        }
 
 
        public void setWb(Workbook wb) {
            this.wb = wb;
        }
 
 
        public Sheet getSheet() {
            return sheet;
        }
 
 
        public void setSheet(int sheetIndex) {
            this.sheet = wb.getSheetAt(sheetIndex);
        }
 
 
        /**
         * 获取总行数
         * 最大行的index值，实际行数要加1 
         * @return
         */
        public int getRowNum() {
            return rowNum;
        }
 
        public int getColumnNum() {
            return columnNum;
        }
 
 
 
        public String getTemplateFilePath() {
            return templateFilePath;
        }
 
 
 
        public static void main(String[] args) throws IOException {
            ExcelUtil excelUtil = new ExcelUtil("d:/q.xlsx",0);
            String[] columnData = excelUtil.getRowData(2);
            for (String string : columnData) {
                System.out.println(string);
            }
             
        }
}