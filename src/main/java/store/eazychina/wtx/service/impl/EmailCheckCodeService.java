package store.eazychina.wtx.service.impl;

import java.util.Date;

import store.eazychina.wtx.service.IEmailCheckCodeService;

public class EmailCheckCodeService implements IEmailCheckCodeService{

	@Override
	public boolean checkCodeTime(long localTime,long beforeEmailCodeTime) {
        long interval = (localTime-beforeEmailCodeTime)/1000;
        
        System.out.println("两次时间间隔:  "+interval+"秒" );
        
        if (interval>60) {
			return true;
		}
		return false;
	}

}
