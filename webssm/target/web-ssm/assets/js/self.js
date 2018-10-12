// 模态窗函数调用判断
function modalJudge(){
    console.log($('#updateData').find('input').eq(0).val());
    if($('#modalInputId').val()==''){
        AddData();
    }else{
        UpdateData();
    }

}

function AddData() {
    console.log(JSON.stringify($("#addData").serializeJSON()));
    $.ajax({
        url: 'AddDataHouse', //请求的url
        type: 'POST', //请求的方式
        async: false,//同步
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify($("#addData").serializeJSON()), //form表单里要提交的内容，里面的input等写上name就会提交，这是序列化
        success: function () {
            document.getElementById("myModalLabelcontent2").innerHTML="添加成功";
            $('#myModal').modal('hide');
            refresh();
        },
        error: function () {
            document.getElementById("myModalLabelcontent2").innerHTML="添加失败";
            $('#myModal').modal('hide');
            alert("添加失败");
        }
    });
}

function UpdateModal(event) {
    document.getElementById("modalTitleName").innerHTML="更新数据";
    document.getElementById("modalButton").innerHTML="更新";
    var form = $('#tableFirst tr:eq(0)').text();
    alert(form);
    for(var i=0; i<=9 ;i++){
        $('#updateData').find('input').eq(i).val($("#tableFirst").find('tr').eq($(event).val()).find('td').eq(i).text());
        console.log($("#tableFirst").find('tr').eq($(event).val()).find('td').eq(i).text());
    }
}

function UpdateData() {
    $.ajax({
        url:'updataData',
        type:'POST',
        data:JSON.stringify($("#addData").serializeJSON()),
        async:false,
        contentType:'application/json;charset=UTF-8',
        error:function () {
            for(var i=0; i<=9 ;i++){
                $('#updateData').find('input').eq(i).val('');
            }
            $('#myModal').modal('hide');
            document.getElementById("myModalLabelcontent2").innerHTML="更新失败";
        },
        success:function () {
            for(var i=0; i<=9 ;i++){
                $('#updateData').find('input').eq(i).val('');
            }
            $('#myModal').modal('hide');
            document.getElementById("myModalLabelcontent2").innerHTML="更新成功";
            refresh();
        }
    });
    document.getElementById("modalTitleName").innerHTML="添加数据";
    document.getElementById("modalButton").innerHTML="添加";
}

function DeleteData(event) {
    $.ajax({
        url:'deleteData',
        type:'POST',
        data:$("#tableFirst").find('tr').eq($(event).val()).find('td').eq(0).text(),
        async:false,
        contentType:'application/json;charset=UTF-8',
        error:function () {
            document.getElementById("myModalLabelcontent2").innerHTML="删除失败";
        },
        success:function () {
            document.getElementById("myModalLabelcontent2").innerHTML="删除成功";
            refresh();
        }
    })
}

function refresh(){
    $.ajax({
        url: 'selectFirst', //请求的url
        type: 'POST', //请求的方式
        dataType:'json',
        async: false,//同步
        contentType:'application/json;charset=UTF-8',
//                  data: $('#tableFirst').serialize(), //form表单里要提交的内容，里面的input等写上name就会提交，这是序列化
        error:function (data) {
            alert('请求失败');
        },
        success:function (data) {
//                      alert(data[0].area);
            var str1 = "";
            //清空table中的html
            $("#tableFirst").html("");
            for (var i = 0; i < data.length; i++) {
                str1 = "<tr>" +
                    "<td name='id'>"+ data[i].id + "</td>" +
                    "<td name='location'>" + data[i].location + "</td>" +
                    "<td name='quoteprice'>" + data[i].quoteprice + "</td>" +
                    "<td name='area'>" + data[i].area + "</td>" +
                    "<td name='price'>" + data[i].price + "</td>" +
                    "<td name='floorlevel'>" + data[i].floorlevel + "</td>" +
                    "<td name='erientation'>" + data[i].erientation + "</td>" +
                    "<td name='preoperty'>" + data[i].property + "</td>" +
                    "<td name='type'>" + data[i].type + "</td>" +
                    "<td name='completion'>" + data[i].completion + "</td>" +
                    "<td><button class='btn-danger' data-toggle='modal' data-target='#myModal2' onclick='DeleteData(this)' value='"+ i +"'>删除</button><button class='btn-default' data-toggle='modal' data-target='#myModal' onclick='UpdateModal(this)' value='"+ i +"'>更新</button></td>" +
                    "</tr>";
                $("#tableFirst").append(str1);
            }
        }
    });
}

function refreshData() {
    $.ajax({
        url: 'selectFirst', //请求的url
        type: 'POST', //请求的方式
        dataType:'json',
        async: false,//同步
        contentType:'application/json;charset=UTF-8',
//                  data: $('#tableFirst').serialize(), //form表单里要提交的内容，里面的input等写上name就会提交，这是序列化
        error:function (data) {
            document.getElementById("myModalLabelcontent2").innerHTML="刷新失败";
            alert('请求失败');
        },
        success:function (data) {
            document.getElementById("myModalLabelcontent2").innerHTML="刷新成功";
//                      alert(data[0].area);
            var str1 = "";
            //清空table中的html
            $("#tableFirst").html("");
            for (var i = 0; i < data.length; i++) {
                str1 = "<tr>" +
                    "<td name='id'>"+ data[i].id + "</td>" +
                    "<td name='location'>" + data[i].location + "</td>" +
                    "<td name='quoteprice'>" + data[i].quoteprice + "</td>" +
                    "<td name='area'>" + data[i].area + "</td>" +
                    "<td name='price'>" + data[i].price + "</td>" +
                    "<td name='floorlevel'>" + data[i].floorlevel + "</td>" +
                    "<td name='erientation'>" + data[i].erientation + "</td>" +
                    "<td name='preoperty'>" + data[i].property + "</td>" +
                    "<td name='type'>" + data[i].type + "</td>" +
                    "<td name='completion'>" + data[i].completion + "</td>" +
                    "<td><button class='btn-danger' data-toggle='modal' data-target='#myModal2' onclick='DeleteData(this)' value='"+ i +"'>删除</button><button class='btn-default' data-toggle='modal' data-target='#myModal' onclick='UpdateModal(this)' value='"+ i +"'>更新</button></td>" +
                    "</tr>";
                $("#tableFirst").append(str1);
            }
        }
    });
}



function reHouseTypeSearch(){
    if(event.keyCode==13){
        HouseTypeSearch();
    }
}

function HouseTypeSearch() {
    var form = $('#houseTypeSearch').val();
    if(form == ''){
        refreshData();
    }else{
        $.ajax({
            url: 'HouseTypeSearch', //请求的url
            type: 'POST', //请求的方式
            dataType:'json',
            async: false,//同步
            contentType:'application/json;charset=UTF-8',
            data: JSON.stringify($("#HouseType").serializeJSON()), //form表单里要提交的内容，里面的input等写上name就会提交，这是序列化
            error:function (data) {
                alert('请求失败');
            },
            success:function (data) {
                //                      alert(data[0].area);
                var str1 = "";
                //清空table中的html
                $("#tableFirst").html("");
                for (var i = 0; i < data.length; i++) {
                    str1 = "<tr>" +
                        "<td>" + data[i].location + "</td>" +
                        "<td>" + data[i].quoteprice + "</td>" +
                        "<td>" + data[i].area + "</td>" +
                        "<td>" + data[i].price + "</td>" +
                        "<td>" + data[i].floorlevel + "</td>" +
                        "<td>" + data[i].erientation + "</td>" +
                        "<td>" + data[i].property + "</td>" +
                        "<td>" + data[i].type + "</td>" +
                        "<td>" + data[i].completion + "</td>" +
                        "</tr>";
                    $("#tableFirst").append(str1);
                }
            }
        });
    }

}
//
// function HouseTypeSearch(){
//     $.ajax({
//         url:'/HouseTypeSearch',
//         type:'post',
//         contentType:"application/json; charset=utf-8",
//         dataType:'String',
//         data:$(" #houseTypeSearch").val(),
//         async: false,//同步
//         success:function(result){
//             alert(result);
//             //回调函数
//             var str1 = "";
//             //清空table中的html
//             $("#tableFirst").html("");
//         },
//         error:function (data) {
//             alert(data);
//             alert("失败了....");
//         }
//     });
// }
//
// function HouseTypeSearch(){
//     alert("错误");
//     alert($('#HouseType').serialize());
//     $.ajax({
//         url:'/HouseTypeSearch',
//         type:'post',
//         dataType:'json',
//         data:$('#HouseType').serialize(),
//         success:function(result){
//             alert(result);
//             //回调函数
//             var str1 = "";
//             //清空table中的html
//             $("#tableFirst tr:not(:first)").html("");
//             for (var i = 0; i < result.length; i++) {
//                 str1 = "<tr>" +
//                     "<td>" + result[i].location + "</td>" +
//                     "<td>" + result[i].quoteprice + "</td>" +
//                     "<td>" + result[i].area + "</td>" +
//                     "<td>" + result[i].price + "</td>" +
//                     "<td>" + result[i].floorlevel + "</td>" +
//                     "<td>" + result[i].erientation + "</td>" +
//                     "<td>" + result[i].property + "</td>" +
//                     "<td>" + result[i].type + "</td>" +
//                     "<td>" + result[i].completion + "</td>" +
//                     "</tr>";
//                 $("#tableFirst").append(str1);
//             }
//         }
//     });
// }