<%@ page language="java" import="java.util.List, com.model.Pojo, java.util.ArrayList" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Master Data</title>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
    crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
    crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $("#circle").change(function() {
        	var circleNo = $(this).val();
            $.ajax({
                type : 'POST',
                url : 'CommonServlet',
                data : { cd: circleNo },
                success : function(data) {
                	var divisionDropdown = $('#division');
                    divisionDropdown.empty().append($('<option>').text('SELECT DIVISION').val(''));
                    $.each(data, function(key, value) {
                        divisionDropdown.append($('<option>').text(value).val(key));
                    });
                },
                error : function(xhr, status, error) {
                    $('#message').text('CircleServlet Error');
                }
            });
        });
        $("#division").change(function(){
        	var divNo = $(this).val();
        	$.ajax({
        		type : 'POST',
        		url : 'CommonServlet',
        		data : {cd : divNo},
        		success : function(data){
        			var eroDropdown = $('#ero');
                    eroDropdown.empty().append($('<option>').text('SELECT ERONAME').val(''));
                    $.each(data, function(key, value) {
                        eroDropdown.append($('<option>').text(value).val(key));
                    });
        		},
        		error : function(xhr, status, error){
        			$('#message').text('DivisionServlet Error');
        		}
        	});
        });
        $('#ero').change(function(){
        	var eroNo = $(this).val();
        	$.ajax({
        		type : 'POST',
        		url : 'CommonServlet',
        		data : {cd : eroNo},
        		success : function(data){
        			var subDropdown = $('#sub');
                    subDropdown.empty().append($('<option>').text('SELECT SUBNAME').val(''));
                    $.each(data, function(key, value) {
                        subDropdown.append($('<option>').text(value).val(key));
                    });
        		},
        		error : function(xhr, status, error){
        			$('#message').text('EroServlet Error');
        		}
        	});
        });
        $("#sub").change(function(){
        	var subNo = $(this).val();
        	$.ajax({
        		type : 'POST',
        		url : 'CommonServlet',
        		data : {cd : subNo},
        		success : function(data){
        			var secDropdown = $('#sec');
                    secDropdown.empty().append($('<option>').text('SELECT SECNAME').val(''));
                    $.each(data, function(key, value) {
                        secDropdown.append($('<option>').text(value).val(key));
                    });
        		},
        		error : function(xhr, status, error){
        			$("#message").text("SecServlet Error");
        		}
        	});
        });
    });
</script>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-7">
                <div class="card">
                    <div class="card-header text-center">
                        <h2>Master Data</h2>
                    </div>
                    <div class="card-body">
                    	<div class="d-flex flex-row d-flex justify-content-around">
                    		<div class=""><label class="mr-auto p-2"> SELECT CIRCLE</label></div>
                    		<div class="col-8 ms-auto p-0">
	                    		<select class="custom-select" id="circle">
	                            <option selected>SELECT CIRCLE</option>
	                            <% 
	                           
	                                String json = (String)request.getAttribute("json");
	                             
	                                String[] keyValuePairs = json.substring(1, json.length() - 1).split(",");
	                                for (String pair : keyValuePairs) {
	                               
	                                    String[] entry = pair.split(":");
	                                    
	                                    String key = entry[0].trim().replaceAll("\"", "");
	                                    String value = entry[1].trim().replaceAll("\"", "");
	                            %>
	                            <option value="<%= key %>"><%= value %></option>
	                            <% } %>
	                        	</select>
                    		</div>
                    	</div>
                    	<div class="d-flex flex-row d-flex justify-content-around">
                    		<div>
                    			<label class="">SELECT DIVISION</label>
                    		</div>
                    		<div class="col-8 ms-auto p-0">
                    			<select class="custom-select" id="division">
                            		<option selected>SELECT DIVISION</option>
                        		</select>
                    		</div>
                    	</div>
                   
                        
                        <div class="d-flex flex-row d-flex justify-content-around mt-2">
                        	<div>
                        		<lable class="">SELECT ERONAME</lable>
                        	</div>
                        	<div class="col-8 ms-auto p-0">
                        		<select class="custom-select" id="ero">
                            		<option selected>SELECT ERONAME</option>
                        		</select>
                        	</div>
                        </div>
                            <div class="d-flex flex-row d-flex justify-content-around mt-2">
                        	<div>
                        		<lable class="">SELECT SUBNAME</lable>
                        	</div>
                        	<div class="col-8 ms-auto p-0">
                        		<select class="custom-select" id="sub">
                            		<option selected>SELECT SUBNAME</option>
                        		</select>
                        	</div>
                        </div>
                        <div class="d-flex flex-row d-flex justify-content-around mt-2">
                        	<div>
                        		<lable class="">SELECT SECNAME</lable>
                        	</div>
                        	<div class="col-8 ms-auto p-0">
                        		<select class="custom-select" id="sec">
                            		<option selected>SELECT SECNAME</option>
                        		</select>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
