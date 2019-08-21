
//用户框失去焦点后验证value值
function oBlur_1() {
    var a = document.getElementsByTagName("input")[0].value;
    if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
    } else { //用户框value值不为空
        document.getElementById("remind_1").innerHTML = "";
        document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
    }
}

//密码框失去焦点后验证value值
function oBlur_2() {
    var b = document.getElementsByTagName("input")[1].value;
    if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    } else { //密码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
    }
}

//验证码失去焦点后验证value值
function oBlur_3() {
    var b = document.getElementsByName("check").value;
    if (!b) { //value值为空
        document.getElementById("remind_3").innerHTML = "请输入验证码（区分大小写）！";
        document.getElementById("check").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    } else { //value值不为空
        document.getElementById("remind_3").innerHTML = "";
        document.getElementById("check").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
    }
}

//用户框获得焦点的隐藏提醒
function oFocus_1() {
    document.getElementById("remind_1").innerHTML = "";
    document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
}

//密码框获得焦点的隐藏提醒
function oFocus_2() {
    document.getElementById("remind_2").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";
}

function oFocus_3() {
    document.getElementById("remind_3").innerHTML = "";
    document.getElementById("check").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";
}

//若输入框为空，阻止表单的提交
function submitTest() {
    // 用户框、密码框、男、女、验证码
    var a = document.getElementsByTagName("input")[0].value;
    var b = document.getElementsByTagName("input")[1].value;
    var c = document.getElementsByTagName("input")[2].value;

    if (!a && !b) { //用户框value值和密码框value值都为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false; //只有返回true表单才会提交
    } else if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    } else if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false;
    }else if (b.length<6) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "密码小于6位，安全度太弱";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    }
    //验证码出错
    else if(!c){
        document.getElementById("remind_3").innerHTML = "请正确填写验证码！";
        return false;
    }
}



//保持聊天窗口滚动条一直在下面
function scrollToBottom(){
    var div = document.getElementsByClassName('Righthead');
    div.innerHTML = div.innerHTML + '<br />';
    div.scrollTop = div.scrollHeight;
}