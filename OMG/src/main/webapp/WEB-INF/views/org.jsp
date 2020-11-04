<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>OMG</title>
</head>
<body id="page-top">
	<!-- wrap -->
	<div id="wrapper">
		<!-- side_bar -->
		<%@include file="inc/side_bar.jsp"%>
		<!-- //side_bar -->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- top_bar -->
				<%@include file="inc/top_bar.jsp"%>
				<!-- //top_bar -->

				<!-- page Content -->
				<div class="container-fluid">

					<!-- 목록 -->
					<div class="row">
						<div class="col-lg-2">
							<div class="card mb-4 py-3 border-left-primary">
								<div class="card-body">
									<div class="list-group-flush">
										<a href="#" class="list-group-item"> 부서 </a> <a href="#"
											class="list-group-item"> 직급 </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-10">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<a href="#" class="btn btn-info btn-icon-split btn-sm"> <span
										class="icon text-white-50"> <i class="fas fa-trash"></i>
									</span> <span class="text">삭제</span>
									</a> <a href="#" class="btn btn-info btn-icon-split btn-sm"> <span
										class="icon text-white-50"> <i class="fas fa-check"></i>
									</span> <span class="text">수정</span>
									</a> <a href="#" class="btn btn-info btn-icon-split btn-sm"> <span
										class="icon text-white-50"> <i
											class="fas fa-arrow-right"></i>
									</span> <span class="text">추가</span>
									</a>
								</div>
								<div class="card-body">
									<!-- collapse 로 만듬 개힘들었는데.. 
									<ul class="navbar-nav" id="dept_position">
										<li class="nav-item active"><a class="nav-link collapsed"
											href="#" data-toggle="collapse" data-target="#dept"
											aria-expanded="false" aria-controls="dept"> <span>OMG</span>
										</a>
											<div id="dept" class="collapse" aria-labelledby="deptList"
												data-parent="#dept_position">
												<div class="bg-white py-2 px-4 collapse-inner rounded">
													<a class="collapse-item collapsed" href="#" id="dept_a"
														data-toggle="collapse" data-target="#dept_2"
														aria-expanded="false" aria-controls="dept_2">전략기획본부</a><br />
													<div id="dept_2" class="collapse"
														aria-labelledby="deptList_2" data-parent="#dept_a">
														<div class="bg-white px-4 py-2 collapse-inner rounded">
															<a class="collapse-item" href="#">전략1팀</a><br />
															<a class="collapse-item" href="#">전략2팀</a><br />
															<a class="collapse-item" href="#">기획1팀</a><br />
															<a class="collapse-item" href="#">기획2팀</a><br />
														</div>
													</div>
													<a class="collapse-item" href="#">경영지원본부</a><br />
													<a class="collapse-item" href="#">기술개발본부</a><br />
													<a class="collapse-item" href="#">영업본부</a><br />

												</div>
											</div></li>
									</ul>
									-->
									<details class="text-primary">
										<summary><input type="checkbox" name="dept" value="10000" /> OMG </summary>
										<div class="bg-white px-4">
											<details>
												<summary><input type="checkbox" name="dept" value="11000" /> 전략기획본부</summary>
												<div class="bg-white px-4 py-2">
													<input type="checkbox" name="dept" value="11100" /> 전략1팀<br />
													<input type="checkbox" name="dept" value="11200" /> 전략2팀<br />
												</div>
											</details>
										</div>
										<div class="bg-white px-4">
											<details>
												<summary><input type="checkbox" name="dept" value="12000" /> 경영지원본부</summary>
												<div class="bg-white px-4 py-2">
													<input type="checkbox" name="dept" value="12100" /> 경영1팀<br />
													<input type="checkbox" name="dept" value="12200" /> 경영2팀<br />
												</div>
											</details>
										</div>
									</details>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- // page Content -->

			</div>
			<!-- //Main Content -->

			<!-- footer -->
			<%@include file="inc/footer.jsp"%>
			<!-- //footer -->

		</div>
		<!-- //Content Wrapper -->
	</div>
	<!-- //wrap -->
	
		<script type="text/javascript">
	$(document).ready(function(){
		$("#setting").attr("class","nav-link");
		$("#setting").attr("aria-expanded","true");
		$("#adminSetting").attr("class","collapse show");
		$("#org").attr("class","collapse-item active");
		});
	
	</script>
	
</body>
</html>