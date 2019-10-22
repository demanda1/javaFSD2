<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Rentickle-Message</title>
</head>

<body>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div style=" text-align:center; background-color: #d3be6c;">
 <div style=" display:inline-block; font-size: 48px; color:blue;">
								<h6>Rentastic</h6>
	</div>
  <br>Hello <b>${name}</b>,
  Thank you, for Renting with us. Here is your Invoice for your Rented products.
  <br>
	<table  class="table table-bordered table-striped" style="background-color: #d3be6c;  >
		<thead class="thead-dark">
			<tr>
				<th></th>
				<th>Product name</th>
				<th>Product Quantity</th>
				<th>Product Price</th>
				
			</tr>
		</thead>
		
		<tbody>
			${tablerows}
		</tbody>		
	</table> 
	</table>
</div>
</body>
</html>