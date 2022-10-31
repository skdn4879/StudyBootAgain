/**
 * 
 */
 
 $("#searchBtn").click(function(){
	//console.log($("#kind").val());
	//console.log($("#search").val());
	location.href = "/qna/list?page=&kind=" + $("#kind").val() + "&search=" + $("#search").val();
});