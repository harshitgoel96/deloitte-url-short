<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basic URL Shortener</title>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
 <script>
 $(document).ready(function() {
 $("#shortUrl").click(function(){
	var encodedUrl= btoa($("#inpuUrl").val());
	
	
	$.ajax({
	    type: 'POST',
	    url:"/shorternUrl",
	    contentType: "application/json",
	    data:JSON.stringify({urlToShortern:encodedUrl}),
	    success:function(data, status){console.log(data);
	    $("#outputUrl").val(document.location.href+data.shortenUrl);
	    
	    $("#outputHyper").attr("href", document.location.href+data.shortenUrl);
	    $("#outputHyper").text( document.location.href+data.shortenUrl);
	    },	
		dataType: 'json'});
	
	
	
	
	
});
 });
 </script>
</head>
<body class="container">
<div class="row">
	<div class="col-md-3">
		<label>Provide URL to Shorten</label>
	</div>
	<div class="col-md-9"><input type="text" id="inpuUrl" style="width: 100%;"></div>
</div>
<div class="row">
	<div class="col-md-3">
		<label>Shortened Url</label>
	</div>
	<div class="col-md-9"><input type="text" id="outputUrl" disabled style="width: 100%;"></div>
</div>
<div class="row">
	<div class="col-md-3">
		<label>short url hyperlink</label>
	</div>
	<div class="col-md-9"><a id="outputHyper"></a></div>
</div>
<div class="row">
	<div class="col-md-4">
		
	</div>
	<div class="col-md-4"><button id="shortUrl">Covert url</button></div>
	<div class="col-md-4">
		
	</div>
</div>
</body>
</html>