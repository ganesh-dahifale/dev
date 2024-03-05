package com.emp.management.empmgmt.controller;

import com.emp.management.empmgmt.constants.EmployeeConstants;
import com.emp.management.empmgmt.dto.EmployeeDto;
import com.emp.management.empmgmt.dto.ResponseDto;
import com.emp.management.empmgmt.service.IEmployeeService;
import com.emp.management.empmgmt.service.impl.EmployeeServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class EmployeeController {
    private IEmployeeService iEmployeeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        iEmployeeService.create(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(EmployeeConstants.STATUS_201,EmployeeConstants.MESSAGE_201));

    }

    @GetMapping("/fetch")
    public ResponseEntity<EmployeeDto> fetchEmployee(@RequestParam Long empCode){
        EmployeeDto employeeDto = iEmployeeService.fetch(empCode);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeeDetails(@RequestBody EmployeeDto employeeDto){
        boolean isUpdated = iEmployeeService.update(employeeDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(EmployeeConstants.STATUS_200,EmployeeConstants.MESSAGE_200));
        }else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(EmployeeConstants.STATUS_417,EmployeeConstants.MESSAGE_417_UPDATE));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteEmployeeDetails(@RequestParam Long empCode){
        boolean isDeleted = iEmployeeService.delete(empCode);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(EmployeeConstants.STATUS_200,EmployeeConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(EmployeeConstants.STATUS_417,EmployeeConstants.MESSAGE_417_DELETE));
        }
    }




}
