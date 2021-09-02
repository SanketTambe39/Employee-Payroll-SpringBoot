package com.bridgelabz.employeepayrollspringboot.services;

import com.bridgelabz.employeepayrollspringboot.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollspringboot.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayrollData(int empId);
}
