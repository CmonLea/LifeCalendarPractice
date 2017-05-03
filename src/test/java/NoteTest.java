import org.junit.Test;


public class NoteTest extends AbstractTest{
@Test
	public void testNoteList(){
	try {
		app.mainScreen().remindPageTag.click();
		app.remindScreen().noteItem.click();
		app.noteScreen().getNoteListDate();
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
}
}
