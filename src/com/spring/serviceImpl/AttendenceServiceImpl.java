package com.spring.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.spring.dao.AttendenceDao;
import com.spring.employee.Attendence;
import com.spring.service.AttendenceService;

@Service
@EnableTransactionManagement
public class AttendenceServiceImpl implements AttendenceService {
	
	@Autowired
	private AttendenceDao attendenceDao;

	@Override
	@Transactional
	public List<Attendence> getAttendenceList() {
		return attendenceDao.getAttendenceList();
	}

	@Override
	@Transactional
	public Attendence getAttendenceById(Long id) {
		return attendenceDao.getAttendenceById(id);
	}

}
