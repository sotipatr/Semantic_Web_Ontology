<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title> </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width;initial-scale=1;maximum-scale=1;user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="HandheldFriendly" content="true">
 
 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
     
  
</head>
<body style="background-color:lightgrey">

	<h2 style="margin-left: 35%">New Lecture</h2>
	<center>
		<fieldset style="border-color:black; width:30%; border-radius: 10px 10px 10px 10px">
			<ul style="list-style-type:none">
				<br>
				<form action="file:///C:/wamp/www/krweb/er12.php" method="get">
				<li style="display: inline"><p>Title</p><input type="text" name="title"></li> <br>
				<li style="display: inline"><p>Professor</p><input type="text" name="prof"></li> <br>
				<li style="display: inline"><p>Day</p><input type="text" name="day"></li> <br> <br>
				<li style="display: inline"><button type="submit">Add</button></li> <br>
				</form>
            </ul>	
		</fieldset>
		
	
		<form action="file:///C:/wamp/www/krweb/er12.php" method="get" id="select_form" type="submit">

		<select name="select_day" form="select_form">
			<option value="monday">Monday</option>
			<option value="tuesday">Tuesday</option>
			<option value="wednesday">Wednesday</option>
			<option value="thursday">Thursday</option>
			<option value="friday">Friday</option>
			<option value="alldays">Alldays</option>
		</select> 
			<button type="submit">View Schedule</button>
		</form>
		<br>
		<style>
			table, th, td { border: 1px solid black;} 
		</style>
		 <table style="width:40%">
			<tr style="background-color:grey">
				<td>Lesson</td>
				<td>Professor</td>
				<td>Day</td>
			</tr>
				<?php
					ini_set('display_errors',1);
					error_reporting(E_ALL);
					$xml = new DOMDocument();
					$xml->load('9_RIGHT_schedule.xml'); /*loading xml file*/
					$valid_xml = $xml->schemaValidate('er9.xsd');
					
					$xml_load=simplexml_load_file("9_RIGHT_schedule.xml") or die("Error: Cannot create object");
					
					if (isset($_GET['title']))
			{
				$title=$_GET['title']; 
			}
			else{
				$title="Not specified";
			}
			
			if (isset($_GET['prof']))
			{
				$prof=$_GET['prof']; 
			}
			else{
				$prof="Not specified";
			}
			if (isset($_GET['day']))
			{
				$day=$_GET['day']; 
			}
			else{
				$day="Not specified";
			}
			/**********************************************/
			if($title=="") $title="Not specified";
			if($prof=="") $prof="Not specified";
			if($day=="") $day="Not specified";
			/**********************************************/
			
			$lesson = $xml_load->addChild('Lesson');
			$lesson->addChild('Title', $title);
			$lecture=$lesson->addChild('Lecture');
			$lecture->addAttribute('Classroom', 'Not specified'); /*default value*/
			$lecture->addChild('Day', $day);
			$lecture->addChild('Time', '00:00-00:00'); /*default value*/
			$lesson->addChild('Professor', $prof);
			
			$xml_load->save("/test.xml");
			
			if (isset($_GET['select_day']))
			{
				$select_day=$_GET['select_day']; 
			}
			else{
				$select_day="Not specified";
			}
			/*View the schedule of all days*/
			if(!isset($_GET['select_day']) || ($_GET['select_day'] == "alldays")){
				foreach($xml_load as $sel_lesson) {
						foreach($sel_lesson->Lecture as $sel_lect) {
						
						echo "<tr><td>";
						echo $sel_lect->Title;
						echo "</td>";
					
						echo "<td>";
						echo $sel_lect->professor;
						echo "</td>";
						
						echo "</td>";
						echo $select_day;
						echo "</td>";
					
						echo "</tr>";
					
						}
					}
			}
			/*View the schedule of a selected day*/
			else{
					foreach($xml_load as $sel_lesson) {
						foreach($sel_lesson->Lecture as $sel_lect) {
						if($sel_lect->Day==$select_day){
						echo "<tr><td>";
						echo $sel_lect->Title;
						echo "</td>";
					
						echo "<td>";
						echo $sel_lect->professor;
						echo "</td>";
						
						echo "</td>";
						echo $select_day;
						echo "</td>";
					
						echo "</tr>";
						}
						}
					}
			}
					?>
		</table> 
	</center>
</body>
 
</html>