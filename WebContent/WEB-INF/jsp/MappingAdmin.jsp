<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td,th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 5px;
}
input[type=text] {
    width: 100%;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

#field {
	margin-bottom: 20px;
}

#add_new {
	float: right;
}

#contentinfo p {
	line-height: 20px;
	margin: 30px;
	padding-bottom: 20px;
	text-align: justify;
	width: 140px;
	color: blue;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	
	function update_values(){
	  document.getElementById("myForm").submit();
	} 
  
</script>
</head>
<body>

	<center>
		<h2 style="color: rebeccapurple;">Biennale 2016</h2>
	</center>
	<center>
		<h4 style="color: cadetblue;"> Json Generator</h4>
		<br>
		
	</center>
<form:form action="mappingUpdate" id="myForm" method="post">
	<table id="maintable">

		<tr>
		    <th>SL No.</th>
			<th>URL</th>
			<th>Des</th>
		</tr>
		<tbody>
		
			<tr>
				<td>1 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>2 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>3 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>4 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>5 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>6 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>7 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>8 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>9 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>10 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
			<tr>
				<td>11 <input type="hidden" size="10" name="slno" ></td>
				<td><input type="text" size="10" name="url" ></td>
				<td><input type="text" size="10" name="des" ></td>
			</tr>
		</tbody>
	</table>
</form:form>
	
	<br>
	<br>
	<input type="button" onclick="update_values();" value="CREATE JSON" style="margin-left: 702px; color: red;" >
	
	

</body>
</html>

