package Method;

import io.appium.java_client.NoSuchContextException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {
    private WebElement _table;
    public Table(WebElement table){
        setTable(table);
    }
    public WebElement getTable(){
        return _table;
    }
    public void setTable(WebElement table){
        this._table=table;
    }
    //获取行数
    public int getRowCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.size();
    }
    //获取列数
    public int getColumnCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.get(0).findElements(By.tagName("td")).size();
    }
    //获取表格的对象
    public WebElement getCell(int rowNO,int colNO) throws NoSuchContextException {
        try {
            List<WebElement> tableRow = _table.findElements(By.tagName("tr"));
            WebElement currentRow = tableRow.get(rowNO-1);
            List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tablecols.get(colNO-1);

            return cell;
        }catch (NoSuchContextException e){
            throw new NoSuchContextException("对象不存在");
        }
    }
    //获取页面对象，by参数用于定位某个表
    public WebElement getWeElementInCell(int rowNo,int colNO,By by) throws NoSuchContextException{
        try {
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowNo-1);
            List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tablecols.get(colNO-1);
            return cell.findElement(by);
        }catch (NoSuchContextException e){
            throw new NoSuchContextException("对象不存在");
        }
    }
}
