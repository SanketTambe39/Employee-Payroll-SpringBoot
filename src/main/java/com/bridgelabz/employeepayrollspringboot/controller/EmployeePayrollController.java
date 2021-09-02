package com.bridgelabz.employeepayrollspringboot.controller;

import com.bridgelabz.employeepayrollspringboot.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollspringboot.dto.ResponceDTO;
import com.bridgelabz.employeepayrollspringboot.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employeepayrollservice")
public class EmployeePayrollController {
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponceDTO> getEmployeePayrollData()
    {
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO("Sanket", 500000);
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        ResponceDTO responceDTO =  new ResponceDTO("Get Call Success : ", employeePayrollData);
        return new ResponseEntity<ResponceDTO>(responceDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        return new ResponseEntity<String>("Get Call Success: " + empId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        return new ResponseEntity<String>("Created Employee Payroll Data For : " + employeePayrollDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        return new ResponseEntity<String>("Update Employee Payroll Data For : " + employeePayrollDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        return new ResponseEntity<String>("Delete Call Success For Id : " + empId,HttpStatus.OK);
    }
}
