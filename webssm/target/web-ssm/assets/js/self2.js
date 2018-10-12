// $(function() {
//     //表单验证
//     $("#loginAdmin").validate({
//         rules: {
//             adminName: {
//                 required:true,
//                 minlength:2
//             },
//             adminPassword: {
//                 required: true,
//                 minlength: 5
//             }
//         },
//         messages: {
//             adminName: {
//                 required: "请输入用户名"
//             },
//             adminPassword: {
//                 required: "请输入密码",
//                 minlength: "密码长度不能小于 5 个字母"
//             }
//         }
//     });
// } );

function LoginAdmin(){
    $.ajax({
        url:'/user/loginAdmin',
        type:'POST',
        async:false,
        contentType:'application/json;charset=UTF-8',
        data:JSON.stringify($("#loginAdmin").serializeJSON()),
        error:function(){
            document.getElementById("mes").innerHTML="用户不存在或密码错误";
        },
        success:function(data){
            if(data==true){
                window.location.href="toindex";
            }else{
                document.getElementById("mes").innerHTML="用户不存在或密码错误";
            }
        }
    });
}

function reLoginAdmin() {
    if(event.keyCode==13){
        LoginAdmin();
    }
}