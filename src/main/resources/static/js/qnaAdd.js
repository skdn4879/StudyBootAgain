let fileCount = 0;
let fileLimit = 5;

let validCheckes = [false, false];

$("#contents").summernote();

//작성 확인
$("#addBtn").click(function(){
    let addFlag = confirm("이대로 작성합니까?");

    if(addFlag){
        if(validCheckes.includes(false)){
            alert("필수 입력을 모두 입력해주세요.");
            return;
        }
        $("#addForm").submit();
    }
});

//파일추가버튼 클릭시
$("#fileAddBtn").click(function(){

    if(fileCount >= fileLimit){
        return;
    }

    fileCount++;

    let fileTemp = $("#fileFormTemp").html();
    $("#fileList").append(fileTemp);

});

//파일 삭제 버튼 클릭시
$("#fileList").on("click", ".fileDeleteBtn", function(){
    $(this).parent().remove();
    fileCount--;
});

$("#writer").blur(function(){
    if($(this).val() == ""){
        validCheckes[0] = false;
        $("#writerErrorMessage").html("작성자는 필수입니다 FE");
    } else {
        validCheckes[0] = true;
        $("#writerErrorMessage").html("");
    }
});

$("#title").blur(function(){
    if($(this).val() == ""){
        validCheckes[1] = false;
        $("#titleErrorMessage").html("제목은 필수입니다 FE");
    } else {
        validCheckes[1] = true;
        $("#titleErrorMessage").html("");
    }
});