<!doctype html>
<html lang="us">
<head>
	<meta charset="utf-8">
	<title>User Add</title>
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">	</script>
	<script src="../js/jquery.jqGrid.min.js" type="text/javascript"></script>
	<script src="../js/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8">	</script>
	<script src="../js/grid.locale-en.js" type="text/javascript"></script>

	<link href="../css/jquery-ui.css" rel="stylesheet">
	<link href="../css/ui.jqgrid.css" rel="stylesheet" type="text/css"   />
	<link href="../css/validationEngine.jquery.css" rel="stylesheet"  type="text/css"/>

	
<style>
.lg-center {
 
    margin: 0px auto;
}
input , select{
width:80%
}
label {
color : blue;
}
</style>
		 
	
</head>
<body>
  

<b><a href="../user/viewUsers.ext"> User </a> >>  Add User </b>
 <hr >
 
		 
 <form action="../user/addUser.ext" id="usrForm" onsubmit="return jQuery(this).validationEngine('validate');">
 <fieldset  > <legend>User Info</legend>
<table  width="100%" height="auto">
	<input type="hidden" name="userInfo.id"/>
	<input type="hidden" name="userInfo.type" value="U" />
	<tr>
		<td><label>User Id : </label></td>
		<td> <input type="text"  class="validate[required,custom[onlyLetterNumber]] text-input" name="userInfo.userId" id="name" /></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td><label>Password : </label></td>
		<td><input type="password" class="validate[required] text-password"  name="userInfo.password" /></td>
		
		<td><label>Gender : </label></td>
		<td> <select  class="validate[required] text-select" ><option value="M">Male</option> <option value="F">Female</option>  </select></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td><label>Department : </label></td>
		<td><select class="validate[required] text-select"  name="userInfo.param1"><option value="A">Department A</option> <option value="B">Department B</option> <option value="C">Department C</option>  </select></td>
		<td><label>DOB : </label></td>
		<td><input type="text" id="datepicker" class="validate[required] text-date" /></td>
		<td><label>Zone : </label></td>
		<td> <select class="validate[required] text-select" name="userInfo.zone.id" ><option value="1">Delhi</option> <option value="3">Agra</option> <option value="2">Noida</option>  </select></td>
	</tr>
	 
	 <tr><td colspan="6">
		
<fieldset  > <legend>Address Info</legend>
 
<table    width="100%" height="auto">
	
	<tr>
		<td><label>Address 1 : </label></td>
		<td> <input type="text" class="validate[required] text-input"  /></td>
		<td><label>Address 2 : </label></td>
		<td> <input type="text" /></td>
		<td><label>Address 3: </label></td>
		<td> <input type="text" /></td>
	</tr>
	<tr>
		<td><label>City : </label></td>
		<td><input type="text" class="validate[required,custom[onlyLetterNumber]] text-input"  /></td>
		<td><label>State : </label></td>
		<td><input type="text" class="validate[required,custom[onlyLetterNumber]] text-input"  /></td>
		<td><label>Zipcode : </label></td>
		<td><input type="text" class="validate[required,custom[zip]] text-input"  /></td>
	</tr>
	<tr>
		<td><label>Mobile : </label></td>
		<td><input type="text" class="validate[required,custom[phone]] text-input" name="userInfo.mobileNumber" /></td>
		<td><label>Email : </label></td>
		<td><input type="email" class="validate[required,custom[email] text-input" /></td>
		<td><label>Country : </label></td>
		<td><input type="text" class="validate[required,custom[onlyLetterNumber]] text-input"  /></td>
	</tr>
	
	
	 
	 
	
</table>
</fieldset>
			 
	 
	 </td></tr>
	 
	 <tr>
		<td colspan="6" align="center">
		<br>
		<button type="submit" id="save" onclick="jQuery('#usrForm').submit();" >Save</button>
		<button type="reset" id="reset" onclick="jQuery('#usrForm').validationEngine('hide')">Reset</button>
		</td>
	</tr>
</table>
</fieldset>
  
</form>

<script>
$("#save").button();
$("#reset").button();
$( "#datepicker" ).datepicker({
	
});
function validate() {
	alert('Succesdsdsdsdsss!');
}
function formSuccess() {
	alert('Success!');
}

function formFailure() {
	alert('Failure!');
}
jQuery(document).ready(function(){
	// binds form submission and fields to the validation engine
	jQuery("#usrForm").validationEngine({
		onFormSuccess:formSuccess,
		onFormFailure:formFailure
		
	});
});

	 
</script>
</body>
</html>
