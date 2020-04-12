package zhiyiting2.test.parkingManagement.service;

import java.util.Date;

import zhiyiting2.model.ResponseModel;

public interface SpecialVehicleService {
	public ResponseModel addSpecialCar(String plateNo,int isEnable,Date validStart,Date validEnd) throws Exception;
	public void updateSpecialCar(int id,String plateNo,int isEnable,Date validStart,Date validEnd) throws Exception;
	public void deleteSpecialCar(Integer id) throws Exception;
}
