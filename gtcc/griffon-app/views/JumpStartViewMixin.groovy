
import java.awt.Cursor

class JumpStartViewMixin {

  Cursor hourglassCursor
  Cursor normalCursor
  
  def busy
  def notBusy

  def buildJumpStartView = {
    build(JumpStartActions)
	build(JumpStartAppDialogs)
	build(JumpStartStatusBar)
	build(JumpStartMenuBar)
	build(JumpStartToolBar)
	
	controller.statusLabel = status
	controller.toolbar = toolbar

	hourglassCursor = new Cursor(Cursor.WAIT_CURSOR)
    normalCursor = new Cursor(Cursor.DEFAULT_CURSOR)
	
    busy = {root.view.setCursor(hourglassCursor) }
    notBusy = {root.view.setCursor(normalCursor) }
	
	controller.busy = busy
	controller.norm = notBusy
  }
}