package com.bridgelabz.employeepayrollspringboot.controller;

import com.bridgelabz.employeepayrollspringboot.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollspringboot.dto.ResponceDTO;
import com.bridgelabz.employeepayrollspringboot.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollspringboot.services.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("employeepayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/employees")
    public ResponseEntity<ResponceDTO> getEmployeePayrollData()
    {
        List<EmployeePayrollData> employeeDataList = null;
        employeeDataList = employeePayrollService.getEmployeePayrollData();
        ResponceDTO responceDTO =  new ResponceDTO("Get Call Success : ", employeeDataList);
        return new ResponseEntity<ResponceDTO>(responceDTO, HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<ResponceDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponceDTO responceDTO = new ResponceDTO("Get Call For Id Successful : ", employeePayrollData);
        return new ResponseEntity<ResponceDTO>(responceDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponceDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        log.debug("Employee DTO: " + employeePayrollDTO.toString());
        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponceDTO responseDTO = new ResponceDTO("Created Employee Payroll Data Successfully : ", employeePayrollData);
        return new ResponseEntity<ResponceDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponceDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponceDTO responseDTO =  new ResponceDTO("Employee Payroll Data Updated Successfully: ", employeePayrollData);
        return new ResponseEntity<ResponceDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponceDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponceDTO responseDTO = new ResponceDTO("Deleted Successfully", "Deleted Id : "+ empId);
        return new ResponseEntity<ResponceDTO>(responseDTO,HttpStatus.OK);
    }
}
