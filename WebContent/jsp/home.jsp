<%@ include file="/common/taglibs.jsp"%>
<head>
	
</head>

<body>
<div style="padding-bottom 10px">
	<b>User: <%=session.getAttribute("username") %> </b>
	</br>
	<c:if test="${role == 'A'}">
				<a href="../user/viewUsers.ext" title="list of all users">List of User </a></br></br>
				<a href="../user/viewOnMap.ext" title="view the last location of users">View On Map </a></br></br></br></br>						
	</c:if>
	<c:if test="${role == 'U'}">
				<a href="#" title="">My Reports </a></br></br>
				<a href="#" title="">New Report</a>	</br></br>
	</c:if>
	<a href="../user/viewUsers.ext" title="" class="dialogify">Change Password</a>	</br></br>
	<a href="../jsp/logout.jsp" title="Logout">Logout</a></br></br></br></br>
	</div>
	
	<div id="dialog">
	change password for
	</div>
	
	
<script>
		/*
		 * jQuery UI Dialog: Load Content via AJAX
		 * http://salman-w.blogspot.com/2013/05/jquery-ui-dialog-examples.html
		 */
		 jQuery(document).ready(function() {
			$("#dialog").dialog({
				autoOpen: false,
				modal: true,
				width: 600,
				height: 300,
				buttons: {
					"Dismiss": function() {
						$(this).dialog("close");
					}
				}
			});
			
			$(".dialogify").on("click", function(e) {
				alert('al');
				e.preventDefault();
				$("#dialog").html("");
				$("#dialog").dialog("option", "title", "Loading...").dialog("open");
				$("#dialog").load(this.href, function() {
					$(this).dialog("option", "title", "Change Password");
				});
			});
			
			
			
		});
	</script>
</body>