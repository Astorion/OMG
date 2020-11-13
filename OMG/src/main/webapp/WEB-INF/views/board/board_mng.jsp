<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 수정</title>
</head>
<body id="page-top">
<!-- wrap -->
<div id="wrapper">
	<!-- side_bar -->
	<%@include file="/WEB-INF/views/inc/side_bar.jsp"%>
	<!-- //side_bar -->
	
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">
			<!-- top_bar -->
			<%@include file="/WEB-INF/views/inc/top_bar.jsp"%>
			<!-- //top_bar -->
		
			<!-- page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-4 text-gray-800">게시글 수정</h1>
				
				<form class="form-horizontal" name="mngFrm" action="${hContext}/board/doSelectLsit.do" method="post">
					<input type="button" class="btn btn-primary btn-icon-split icon text-white-100"  value="목록" id="moveList"  style="float: right;  margin: 13px;" />
					<input type="button" class="btn btn-primary btn-icon-split icon text-white-100"  value="삭제" id="doDeleteBtn"  style="float: right;  margin: 13px;" />
					<input type="button" class="btn btn-primary btn-icon-split icon text-white-100"  value="수정"  id="doUpdateBtn" style="float: right;  margin: 13px;" />
					<input type="hidden" name="boardSeq"     id="boardSeq"  value="${vo.boardSeq}" />
					<input type="hidden" name="div"     id="div"  value="${vo.getDiv()}" />
					<!-- <input type="hidden" name="boardSeq" 	id="boardSeq" /> -->
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="title" id="title" placeholder="제목" maxlength="200"
								   value="${vo.title}"
							/>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">수정자</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="modId" id="modId" placeholder="수정자" maxlength="20">
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<textarea  class="form-control" rows="15" cols="40" name="contents" id="contents">${vo.contents}</textarea>
						</div>
					</div>
				</form>
			</div>
			<!-- // page Content -->
		</div>
		<div class="container col-lg-12" id="comment_list_div">
			<div class="page-header">
				<!-- h4>댓글</h4> -->
				<label for="" class="col-sm-2 control-label">댓글</label>
			</div>
			<!-- <div>
				<ul class="list-group" id="comment_list">
					<li class="list-group-item" style="width: 1349px;">
					<div class="row">
						<input type="hidden" name="commentNum" id="commentNum" value="10069">
						<input type="hidden" name="upNum" id="upNum" value="0">
						<a href="#" class="col-lg-1"><img src="/N1/images/profile/man.jpeg" alt="프로필 사진" width="72" height="72"></a>
						<div id="comment_area" class="col-lg-10">
							<div>
								<label id="modId">eee</label>
							</div>
							<div>
								<p id="comment_contents">asd</p>
							</div>
							<div>2020-11-12 16:55:26<a href="#" onclick="reply(this); return false;" class="btn btn-link">답글쓰기</a></div>
						</div>
						<div class="dropdown col-lg-1 text-right">
							<button class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">...<span class="caret"></span></button>
							<ul class="dropdown-menu">
								<li><a href="#" onclick="comment_modify(this); return false;">수정</a></li>
								<li><a href="#" onclick="comment_del(this); return false;">삭제</a></li>
							</ul>
						</div>
					</div>
					</li>
				</ul>
			</div> -->
			
			<ul class="list-group" id="comment_list">
				<!-- 댓글 영역 -->
			</ul>
			<div class="panel panel-body panel-default">
				<form class="form-horizontal" name="comment_reg_frm" id="comment_reg_frm" >
					<div class="form-group col-lg-10">
						<div>
							<label>현재 로그인한 사용자 ID</label>
							</div>
						<div >
							<textarea class="form-control" style="resize:none;" id="write_contents" name="write_contents" rows="3" cols="100" placeholder="댓글을 입력하세요."></textarea>
						</div>
						<div style="float: right;">
							<input type="button" id="comment_reg_btn" class="btn btn-primary btn-icon-split icon text-white-100"  value="등록" style="margin: 13px;" />
						</div>
						<input type="hidden" name="regId" id="regId" value="admin"/>
						<%-- <input type="hidden" name="boardSeq" id="boardSeq" value="${vo.getBoardSeq()}" /> --%>
						<input type="hidden" name="boardSeq" id="boardSeq" value="${vo.boardSeq}" />
						<input type="hidden" name="upNum" id="upNum" value="0"/>
						<!-- <input type="hidden" name="work_div" id="work_div" /> -->
					</div>
				</form>
			</div>
		</div>
		<!-- //Main Content -->

		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
		<!-- //footer -->
	</div>
	<!-- //Content Wrapper -->
	
</div>
<!-- //wrap -->
	<script type="text/javascript">
	$(document).ready(function()
	{
		$("#Pages").attr("class","nav-link");
		$("#Pages").attr("aria-expanded","true");
		$("#collapsePages").attr("class","collapse show");
		$("#blank").attr("class","collapse-item active");
		drawComment();
	});

	function moveToListView()
	{
		window.location.href="${hContext}/board/doSelectList.do?div="+$("#div").val();
	}

	$("#moveList").on("click",function()
			{
		//console.log("moveList");
		moveToListView();
	});

	//삭제
	$("#doDeleteBtn").on("click", function() 
	{
		alert("#doDeleteBtn");
		
		var boardSeq = $("#boardSeq").val();
		
		if(false==confirm("삭제 하시겠습니까?"))return;

		$.ajax({
			type:"POST",
			url:"${hContext}/board/doDelete.do",
			dataType:"html", 
			data:{
					"boardSeq" :$("#boardSeq").val(),
			},
			success:function(data)
			{//성공
			//console.log("data="+data);
			//alert("data:"+data);
			
			//json 분리해서 변수
			var jsonObj = JSON.parse(data);
			console.log("msgId="+jsonObj.msgId);
			console.log("msgContents="+jsonObj.msgContents);

				if(null !=jsonObj && jsonObj.msgId=="1")
				{
					alert(jsonObj.msgContents);
					//board_list.jsp로 이동
					moveToListView();
				}
			},
			error:function(xhr,status,error)
			{//실패
			 alert("error:"+error);
			},
			complete:function(data){
			
			}
		  
	});//--ajax
		
	});

	$("#doUpdateBtn").on("click", function() 
	{
			console.log("#doUpdateBtn");
			
			var title = $("#title").val();
			console.log("title:"+title);
			if(null == title || title.trim().length==0){
				$("#title").focus();
				alert("제목을 입력하세요.");
				return;
			}
			
			var modId = $("#modId").val();
			console.log("modId:"+modId);
			if(null == modId || modId.trim().length==0){
				$("#modId").focus();
				alert("등록자를 입력하세요.");
				return;
			}
			
			var contents = $("#contents").val();
			console.log("contents:"+contents);
			if(null == contents || contents.trim().length==0){
				$("#contents").focus();
				alert("내용을 입력하세요.");
				return;
			}			

			if(false==confirm("수정 하시겠습니까?"))return;

			$.ajax({
				type:"POST",
				url:"${hContext}/board/doUpdate.do",
				dataType:"html", 
				data:{
						"boardSeq" : $("#boardSeq").val(),
						"div" :$("#div").val(),
						"title":$("#title").val(),
						"contents":$("#contents").val(),
						"modId":$("#modId").val()
				},
				success:function(data)
				{//성공
				//console.log("data="+data);
				//alert("data:"+data);
				
				//json 분리해서 변수
				var jsonObj = JSON.parse(data);
				console.log("msgId="+jsonObj.msgId);
				console.log("msgContents="+jsonObj.msgContents);

					if(null !=jsonObj && jsonObj.msgId=="1")
					{
						alert(jsonObj.msgContents);
						moveToListView();
					}
				},
				error:function(xhr,status,error)
				{
				 alert("error:"+error);
				},
				complete:function(data){
				
				}

		});//--ajax


			
	});

	function drawComment()
	{
		commentList = null;
		var boardSeq = "${vo.boardSeq}";
		console.log("게시글 번호 : "+boardSeq);

		$.ajax({
			type : "GET",
			url : "${hContext}/comments/doSelectList.do",
			dataType : "html",
			data : {
				"boardSeq" : boardSeq
			},
			success : function(data) 
			{//성공
				//console.log("data=" + data);
				commentList = JSON.parse(data);
				
				var html ="";
				var index = 0;
				if(null != commentList && commentList.length>0){
					for(var vo of commentList){
						var col = 10;
						html += "<li class='list-group-item' style='width: 1335px;border-left-width: 1px;left: 10px;'>";
						html += "<div class='row'>";
						html += "<input type='hidden' name='commentNum' id ='commentNum' value='"+vo.commentNum+"'/>";
						html += "<input type='hidden' name='upNum' id ='upNum' value='"+vo.upNum+"'/>";
						if( vo.upNum != 0){
							html += "<div class='col-lg-1'></div>";
							col--;
						}
						/* html += "<a href='#' class='col-lg-1'>";
						// 이미지 가져오면 수정
						html += "<img src='/N1/images/profile/man.png' alt='프로필 사진' width='72' height='72'/>";
						html += "</a>"; */
						html += "<div id='comment_area' class='col-lg-"+col+"'>";
						html += "<div><label id='modId'>"+vo.modId+"</label></div>";
						html += "<div><p id='comment_contents'>"+vo.contents+"</p></div>";
						html += "<div>"+vo.modDt+"<a href='#' onclick='reply(this); return false;' class='btn btn-link'>답글쓰기</a></div>";
						html += "</div>";
						// 세션 ID로 변경
						if(vo.modId=="admin"){
						html += "<div class='dropdown col-lg-1 text-right'>";
						html += "<button class='btn btn-default btn-xs dropdown-toggle' data-toggle='dropdown'>";
						html += "...<span class='caret'></span>";
						html += "</button>"; 
						html += "<ul class='dropdown-menu'>";	
						html += "<li><a href='#' onclick='comment_modify(this); return false;'>수정</a></li>";	
						html += "<li><a href='#' onclick='comment_del(this); return false;'>삭제</a></li>";	
						html += "</ul>";
						html += "</div>";
						}
						html += "</div>";
						html += "</li>";
						
					}
				} else {
					html += "<div class='text-center'><label>등록된 댓글이 없습니다.</label></div>";
				}
				$("#comment_list").empty();
				$("#comment_list").append(html);
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			}
		});//--ajax
		
	}; //-- drawComment

	function drawComment_write()
	{
		var html = '<div class="panel panel-body panel-default" id="reply_div">';
		html += '<div class="panel panel-body panel-default" id="comm_div">';
		html += '<div class="col-lg-1"></div>';
		html += '<form class="form-horizontal" name="reply_reg_frm" id="reply_reg_frm" >';
		html += '<div class="form-group col-lg-10">';
		html += '<div><label>현재 로그인한 사용자 ID</label></div>';
		html += '<div><textarea class="form-control" style="resize:none;" id="write_contents" name="write_contents" rows="6" cols="100" placeholder="댓글을 입력하세요."></textarea></div>';
		html += '<input type="hidden" name="commentNum" id="commentNum" value="" />';
		html += '<input type="hidden" name="upNum" id="upNum" value="" />';
		html += '<input type="hidden" name="regId" id="regId" value="admin"/>';
		html += '<input type="hidden" name="boardSeq" id="boardSeq" value="${vo.getBoardSeq()}" />';
		html += '</div>';
		html += '</form>';
		html += '<div class="text-right col-lg-11">';
		html += '<input type="button" id="reply_cancel_btn" onclick="reply_remove();" class="btn btn-primary" value="취소" />';
		html += '<input type="button" id="reply_reg_btn" onclick="reply_insert();" class="btn btn-primary" value="등록" />';
		html += '</div>';
		html += '</div>';
		return html;
	}

	// 답글쓰기 클릭
	function reply(r)
	{
		var parent = $(r).parents("div.row");
		var replyDiv = $(r).parents("li.list-group-item");
		var upNum = parent.children('input#commentNum').val()
		console.log(upNum);
		var html = drawComment_write();
		$("#reply_div").remove();
		replyDiv.append(html);
		var frm = document.reply_reg_frm;
		frm.upNum.value = upNum;
		$(frm.write_contents).focus();
		
	}

	// 답글달기 취소
	function reply_remove()
	{
		$("#reply_div").remove();
	}
	
	// 답글달기 등록
	function reply_insert()
	{
		var reply_frm = document.reply_reg_frm;
		var comment_frm = document.comment_reg_frm;
		console.log(reply_frm.upNum.value);
		// 댓글 널 체크
		var cotents = reply_frm.write_contents.value;
		if (null == cotents || cotents.trim().length == 0) 
		{
			$(frm.write_contents).focus();
			alert("댓글을 입력하세요!");
			return;
		}
		
		comment_frm.upNum.value = reply_frm.upNum.value;
		comment_frm.write_contents.value = reply_frm.write_contents.value;
		$("#comment_reg_btn").trigger('click');
	}

	// 댓글 등록
	$("#comment_reg_btn").on('click',function(){
		var frm = document.comment_reg_frm;
		var cotents = frm.write_contents.value;
		/* var upNum = $("#upNum").val(); */
		if (null == cotents || cotents.trim().length == 0) {
			$("#write_contents").focus();
			alert("댓글을 입력하세요!");
			return;
		}
		// 댓글 쓰기 부분 form 으로 변경
		// hidden 값 추가해서 답글 쓰기 부분 누르면 댓글 번호 추가 하면서 textarea에 해당 댓글 사용자 ID 출력(selectOne)
		// id를 버튼처럼 해서 누르면 사라지고 upnum도 초기화
		// 댓글 등록
		var formData = $("#comment_reg_frm").serialize();
		$.ajax({
			type : "POST",
			url : "${hContext}/comments/doInsert.do",
			dataType : "html",
			data : formData,
			success : function(data) { //성공
				console.log("data=" + data);
				var msg = JSON.parse(data);
				alert(msg.msgContents);
				drawComment();
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			}
		});//--ajax
		
		$("#write_contents").val('');
		
	}); // 댓글 쓰기

	// 댓글 수정 클릭
	function comment_modify(e){
		var parent = $(e).parents("div.row");
		var replyDiv = $(e).parents("li.list-group-item");
		var upNum = parent.children('input#upNum').val();
		var commentNum = parent.children('input#commentNum').val();
		var contents = parent.find('p#comment_contents').text();
		console.log(upNum);
		console.log(commentNum);
		//var parent = e.parentNode.parentNode.parentNode.parentNode;
		//var replyDiv = $(parent.parentNode);
		//var vo = commentList[parent.firstChild.value];
		var html = drawComment_write();
		$("#reply_div").remove();
		replyDiv.append(html);
		
		var frm = document.reply_reg_frm;
		frm.upNum.value = upNum;
		frm.commentNum.value = commentNum; 
		$(frm.write_contents).val(contents);
		$(frm.write_contents).focus();
		$("#reply_reg_btn").val("수정");
		$("#reply_reg_btn").attr("onclick","reply_update();");
	}
	
	// 수정 버튼 클릭
	function reply_update()
	{
		
		var frm = $("#reply_reg_frm").serialize();
		if (false == confirm("수정 하시겠습니까?")) return;
		
		$.ajax({
			type : "POST",
			url : "${hContext}/comments/doUpdate.do",
			dataType : "html",
			data : frm,
			success : function(data) 
			{ //성공
				console.log("data=" + data);
				var msg = JSON.parse(data);
				alert(msg.msgContents);
				drawComment();
			},
			error : function(xhr, status, error) 
			{
				alert("error:" + error);
			}
		});//--ajax
	}

	//댓글삭제
	function comment_del(e){
		var parent = $(e).parents("div.row");
		var commentNum = parent.children('input#commentNum').val();
		
		if (false == confirm("정말로 하시겠습니까? 삭제 시 연결된 답글들도 전부 삭제 됩니다.")) return;
		
		console.log("삭제");
		// 삭제시 id는 연결된 session에 로그인된 아이디값
		$.ajax({
			type : "POST",
			url : "${hContext}/comments/doDelete.do",
			dataType : "html",
			data : {
				"regId" : "admin",
				"commentNum" : commentNum
			},
			success : function(data) { //성공
				console.log("data=" + data);
				var msg = JSON.parse(data);
				alert(msg.msgContents);
				drawComment();
			},
			error : function(xhr, status, error) {
				alert("error:" + error);
			}
		});//--ajax
	}
	
	</script>
</body>
</html>