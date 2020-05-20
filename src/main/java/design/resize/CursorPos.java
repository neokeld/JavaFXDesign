package design.resize;

import javafx.scene.Cursor;
import javafx.scene.Scene;

public class CursorPos {

    double sceneWidth;
    double sceneHeight;
	double mouseEventX;
	double mouseEventY;
	private int borderSize;
	
	public CursorPos(Scene scene, double mouseEventX, double mouseEventY, int borderSize) {
        this.sceneWidth = scene.getWidth();
        this.sceneHeight = scene.getHeight();
		this.borderSize = borderSize;
		this.mouseEventX = mouseEventX;
		this.mouseEventY = mouseEventY;
	}
	
	public boolean nw() {
		return mouseEventX < borderSize && mouseEventY < borderSize;
	}
	
	public boolean sw() {
		return mouseEventX < borderSize && mouseEventY > sceneHeight - borderSize;
	}
	
	public boolean ne() {
		return mouseEventX > sceneWidth - borderSize && mouseEventY < borderSize;
	}
	
	public boolean se() {
		return mouseEventX > sceneWidth - borderSize && mouseEventY > sceneHeight - borderSize;
	}
	
	public boolean w() {
		return mouseEventX < borderSize;
	}
	
	public boolean e() {
		return mouseEventX > sceneWidth - borderSize;
	}

	public boolean n() {
		return mouseEventY < borderSize;
	}
	
	public boolean s() {
		return mouseEventY > sceneHeight - borderSize;
	}

	public Cursor getCursorKind() {
		if (this.nw()) {
		    return Cursor.NW_RESIZE;
		} else if (this.sw()) {
		    return Cursor.SW_RESIZE;
		} else if (this.ne()) {
		    return Cursor.NE_RESIZE;
		} else if (this.se()) {
		    return Cursor.SE_RESIZE;
		} else if (this.w()) {
		    return Cursor.W_RESIZE;
		} else if (this.e()) {
		    return Cursor.E_RESIZE;
		} else if (this.n()) {
		    return Cursor.N_RESIZE;
		} else if (this.s()) {
		    return Cursor.S_RESIZE;
		} else {
		    return Cursor.DEFAULT;
		}
	}
}
