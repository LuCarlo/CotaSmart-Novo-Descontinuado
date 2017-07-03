<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="inicializacao/iniciarHead.jsp" />
</head>
<body>
	<c:import url="inicializacao/iniciarBody.jsp" />

	<script type="text/javascript">
		// Initialize collapse button
		$(".button-collapse").sideNav();
		// 		Initialize collapsible (uncomment the line below if you use the dropdown variation)
// 		$('.collapsible').collapsible();

		// Show sideNav
// 		$('.button-collapse').sideNav('show');
		// Hide sideNav
// 		$('.button-collapse').sideNav('hide');
		// Destroy sideNav
// 		$('.button-collapse').sideNav('destroy');
	</script>
	<ul id="slide-out" class="side-nav">
		<li><div class="user-view">
				<div class="background">
					<img src="images/office.jpg">
				</div>
				<a href="#!user"><img class="circle" src="images/yuna.jpg"></a>
				<a href="#!name"><span class="white-text name">John Doe</span></a> <a
					href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
			</div></li>
		<li><a href="#!"><i class="material-icons">cloud</i>First
				Link With Icon</a></li>
		<li><a href="#!">Second Link</a></li>
		<li><div class="divider"></div></li>
		<li><a class="subheader">Subheader</a></li>
		<li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
	</ul>
	<a href="#" data-activates="slide-out" class="button-collapse"><i
		class="material-icons">menu</i></a>
</body>
</html>