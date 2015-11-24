package sample.client.ui;

import com.google.gwt.user.client.*;
import com.google.gwt.user.client.ui.*;

public class MainPanel implements HistoryListener {

	public static final String INIT_STATE = "initstate";
	
	private Label                   label;
	private VerticalPanel          vPanel;
	private Hyperlink   link1,link2,link3,link4;
	
	public MainPanel() {
		// создавать компоненты пользовательского интерфейса
		label  = new Label();
		vPanel = new VerticalPanel();
		vPanel.setStyleName("panelstyle");
	
		link1 = new Hyperlink("link1","http://devlife.com/?rss=sfkj");
		link2 = new Hyperlink("link2","link2token");
		link3 = new Hyperlink("link3","aaaaaaa");
		link4 = new Hyperlink("link4","bbbbbbb");
		vPanel.add(label);
		vPanel.add(link1);
		vPanel.add(link2);
		vPanel.add(link3);
		vPanel.add(link4);
		
		// добавить в MainPanel прослушивание истории
		History.addHistoryListener(this);
	
		// проверить, если есть какие-либо токены проходили при запуске с помощью URI браузера
		String token = History.getToken();
		if( token.length()==0 )
			onHistoryChanged(INIT_STATE);
		else
			onHistoryChanged(token);
	}
	
	public Widget getWidget(){
		return vPanel;
	}
	
	/**
	 * этот метод вызывается, когда вперед/назад кнопки вызывается в браузере.
	 * это также вызывается, когда гиперссылки (генерируемые приложением) щелчке.
	 */
	@Override
	public void onHistoryChanged(String historyToken) {
		// при прохождении маркера, сделать что-то, чтобы обновить состояние вашего приложения
		// этот метод вызывается, когда содержимое MainPanel должны быть изменены в связи с изменением состояния.
		// в контексте этого приложения, изменение состояния представляет собой новый URL-адрес загружается в RSS читателя.
		if( historyToken.equals(INIT_STATE) )
			label.setText("Там непередается URL-токен в браузере");
		else
			label.setText("Получил новый маркер изменения истории браузера: "+historyToken);
	}

}
