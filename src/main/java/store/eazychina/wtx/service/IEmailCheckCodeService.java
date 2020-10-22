package store.eazychina.wtx.service;

public interface IEmailCheckCodeService {


	public boolean checkCodeTime(long localTime, long beforeEmailCodeTime);
}
