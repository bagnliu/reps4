$(function(){
    /*地址栏传参 获取参数*/
    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
    // 调用方法
    var id = GetQueryString("id");
    var num = GetQueryString("num");
    if(id==1){ //学生登录
        $(".student_nav").show();
    }else if(id==2){ //管理员登录
        $(".admin_nav").show();
    }

    /*弹窗展示事件*/
    /* 运动员报名 点击事件*/
    $(".run_enroll").click(function(){
        $(".mask").show();
        $(".maskContent").show();
    });
    /* 志愿者报名 点击事件*/
    $(".run_volunteer").click(function(){
        $(".mask").show();
        $(".volunteerContent").show();
    });
    /*成绩查询 点击事件*/
    $(".result_select").click(function(){
        $(".mask").show();
        $(".reaultContent").show();
    });
    /*管理员点击成绩录入 点击事件*/
    $(".admin_enter").click(function(){
        $(".mask").show();
        $(".adminContent").show();
    });
    /*点击关闭弹窗*/
    $(".close").click(function(){
        $(".mask").hide();
        $(".maskContent").hide();
        $(".volunteerContent").hide();
        $(".reaultContent").hide();
        $(".adminContent").hide();
    });

    /*报名查询操作*/
    /*运动员报名 志愿者报名*/
    $(".run_btn").click(function(){
    	 var boy_100m = $("input[name='boy_100m']:checked").val();
    	 var boy_800m = $("input[name='boy_800m']:checked").val();
    	 var boy_5000m = $("input[name='boy_5000m']:checked").val();
    	 var boy_relay = $("input[name='boy_relay']:checked").val();
    	 var boy_height = $("input[name='boy_height']:checked").val();
    	 var boy_long = $("input[name='boy_long']:checked").val();
    	 var girl_100m = $("input[name='girl_100m']:checked").val();
    	 var girl_400m = $("input[name='girl_400m']:checked").val();
    	 var girl_2000m = $("input[name='girl_2000m']:checked").val();
    	 var girl_relay = $("input[name='girl_relay']:checked").val();
    	 var girl_height = $("input[name='girl_height']:checked").val();
    	 var girl_long = $("input[name='girl_long']:checked").val();
    	 var volunteer_court = $("input[name='volunteer_court']:checked").val();
    	 var volunteer_waiting = $("input[name='volunteer_waiting']:checked").val();
    	 var volunteer_logistics = $("input[name='volunteer_logistics']:checked").val();
        if((boy_100m==""&&boy_800m==""&&boy_5000m==""&&boy_relay==""&&boy_height==""&&boy_long==""&&
            girl_100m==""&&girl_400m==""&&girl_2000m==""&&girl_relay==""&&girl_height==""&&girl_long=="")||(volunteer_court==""&&volunteer_waiting==""&&volunteer_logistics=="")){
            alert("至少选择一项才可以报名！");
            return false;
        }else {
            $.ajax({
                url : "ProjectServlet",
                type : "POST",
                data : {
                    "boy_100m" : boy_100m,
                    "boy_800m" : boy_800m,
                    "boy_5000m" : boy_5000m,
                    "boy_relay" : boy_relay,
                    "boy_height" : boy_height,
                    "boy_long" : boy_long,
                    "girl_100m" : girl_100m,
                    "girl_400m" : girl_400m,
                    "girl_2000m" : girl_2000m,
                    "girl_relay" : girl_relay,
                    "girl_height" : girl_height,
                    "girl_long" : girl_long,
                    "volunteer_court" : volunteer_court,
                    "volunteer_waiting" : volunteer_waiting,
                    "volunteer_logistics" : volunteer_logistics,
                    "number_id":num
                },
                success : function(data) {
                	console.log(data)
                	var data =  JSON.parse(data)
					if (data.code == "1") {
						alert("报名成功!");
					}else{
						alert("提交失败!");
					}
                },
                error:function(data){
                	console.log(data)
                }
            });
            return false;
        }
    });
    /*管理员 成绩录入*/
    $("#admin_btn").click(function(){
        var project = $(".admin_project").val();
        var name = $(".admin_name").val();
        var college = $(".admin_college").val();
        var achievement = $(".admin_achievement").val();
        var ranking = $(".admin_ranking").val();
        if(project==""||name==""||college==""||achievement==""||ranking==""){
            alert("数据不能为空！");
            return false;
        }else {
            $.ajax({
                url : "SaveServlet",
                type : "POST",
                data : {
                    "project" : project,
                    "name" : name,
                    "college" : college,
                    "achievement" : achievement,
                    "ranking" : ranking
                },
                success : function(data) {
                	console.log(data)
                	var data =  JSON.parse(data)
					if (data.code == "1") {
						alert("录入成功!");
					}else{
						alert("提交失败!");
					}
                }
            });
        }
        return false;
    });
    /*查询成绩*/
    $("#condition_btn").click(function(){
        console.log($(".reault_select").val());
        $.ajax({
            url : "SelectServlet",
            type : "POST",
            data : {
                "project" : $(".reault_select").val()
            },
            success : function(data) {
            	var data =JSON.parse(data);
                var tag = "";
                if(data == ""){
                	tag='<tr>'+
                    '<td>暂无数据</td>'+
                    '<td>暂无数据</td>'+
                    '<td>暂无数据</td>'+
                    '<td>暂无数据</td>'+
                    '</tr>';
                }else{
                	$.each(data,function(i,e){
                    	tag+='<tr>'+
                        '<td>'+e.ranking+'</td>'+
                        '<td>'+e.achievement+'</td>'+
                        '<td>'+e.username+'</td>'+
                        '<td>'+e.college+'</td>'+
                        '</tr>';
                    });
                }
                $(".select_conditionTitle").html($(".reault_select").val());
                $(".select_conditionContent").html(tag);
            }
        });
    });
});