package sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import sample.client.ui.*;

/** Entry point classes define <code>onModuleLoad()</code>. */
public class App implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// создать MainPanel
		// подключить свою способность справляться с историей браузера
		MainPanel panel = new MainPanel();

		// добавить панель в DOM браузера
		// и удалить заставки/загрузки
		addWidgetToDOM("widget-div",panel.getWidget());
		removeElementFromDOM("loading");
	}

	/** 
	 * Этот метод добавляет элемент идентифицированный в DOM браузера
	 */
	public void addWidgetToDOM(String s, Widget widget) throws IllegalArgumentException {
		// утверждает, что данная строка не нулевым или пустым:
		if( s==null )
			throw new IllegalArgumentException("String is null");
		if( s.trim().equals("") )
			throw new IllegalArgumentException("String is empty");
		// утверждает, что данная виджет не является нулевым:
		if( widget==null )
			throw new IllegalArgumentException("Widget can not be null");
		
		RootPanel.get(s).add(widget);
	}
	
	/** 
	 * Этот метод удаляет элемент идентифицированный из DOM браузера
	 */
	public void removeElementFromDOM(String s) throws IllegalArgumentException {
		// утверждает, что данная строка не нулевым или пустым:
		if( s==null )
			throw new IllegalArgumentException("String is null");
		if( s.trim().equals("") )
			throw new IllegalArgumentException("String is empty");
		
		Element loading = DOM.getElementById(s);
		DOM.removeChild(RootPanel.getBodyElement(),loading);
	}
	
}
