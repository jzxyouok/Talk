//切换应用类型单选按钮事件
function changeAppType(item) {
    var appType = item.value;
    if (appType == 1) {//测试应用
        $('#myself_type_desc').hide();
        $('#demo_type_desc').show();
        $('#sdkAppIdDiv').hide();
        $('#accountTypeDiv').hide();
    } else if (appType == 0) {//自建应用
        $('#demo_type_desc').hide();
        $('#myself_type_desc').show();
        $('#sdkAppIdDiv').show();
        $('#accountTypeDiv').show();
    }
}
//选择应用类型
function selectApp() {
    var appType = $('input[name="app_type_radio"]:checked').val();
    if (appType == 1) {//测试应用

        loginInfo.sdkAppID = loginInfo.appIDAt3rd = sdkAppID;
        loginInfo.accountType = accountType;
    } else if (appType == 0) {//自建应用
        if ($("#sdk_app_id").val().length == 0) {
            alert('请输入sdkAppId');
            return;
        }
        if (!validNumber($("#sdk_app_id").val())) {
            alert('sdkAppId非法,只能输入数字');
            return;
        }
        if ($("#account_type").val().length == 0) {
            alert('请输入accountType');
            return;
        }
        if (!validNumber($("#account_type").val())) {
            alert('accountType非法,只能输入数字');
            return;
        }
        loginInfo.sdkAppID = loginInfo.appIDAt3rd = $('#sdk_app_id').val();
        loginInfo.accountType = $('#account_type').val();
    }
    $('#select_app_dialog').modal('hide');
    //调用tls登录服务
    tlsLogin();
}
//自写函数
function select() {
        loginInfo.sdkAppID = loginInfo.appIDAt3rd = 1400003328;
        loginInfo.accountType = 1019;
    //调用tls登录服务
		tlsLogin();
}
//tls登录
function tlsLogin() {
    log.info('start tlsLogin');
    // 跳转到TLS登录页面
    TLSHelper.goLogin({
        sdkappid: loginInfo.sdkAppID,
        acctype: loginInfo.accountType,
        url: callBackUrl
    });
}
//第三方应用需要实现这个函数，并在这里拿到UserSig
function tlsGetUserSig(res) {
    //成功拿到凭证
    if (res.ErrorCode == TlsErrorCode.OK) {
        log.info('tlsGetUserSig success');
        //从当前URL中获取参数为identifier的值
        loginInfo.identifier = TLSHelper.getQuery("identifier");
        //拿到正式身份凭证
        loginInfo.userSig = res.UserSig;
        //从当前URL中获取参数为sdkappid的值
        loginInfo.sdkAppID = loginInfo.appIDAt3rd = TLSHelper.getQuery("sdkappid");
        //从当前URL中获取参数为acctype的值
        loginInfo.accountType = TLSHelper.getQuery("acctype");
        //登录qavSDK
        qavSdkLogin();

    } else {
        //签名过期，需要重新登录
        if (res.ErrorCode == TlsErrorCode.SIGNATURE_EXPIRATION) {
            tlsLogin();
        } else {
            log.info('tlsGetUserSig failed:[' + res.ErrorCode + "]" + res.ErrorInfo);
            alert("[" + res.ErrorCode + "]" + res.ErrorInfo);
        }
    }
}
//初始化demo
function initDemoApp() {
    $("body").css("background-color", '#2f2f2f');
    $('#qavSdkDemoDiv').show();
    $('#userId').html(loginInfo.identifier);

}
//返回登录
function quitClick() {
    $('#qavSdkDemoDiv').hide();
    //是否登录
    if (loginInfo.identifier == null) {
        window.location.href = callBackUrl;
        //$('#select_app_dialog').modal('show');
        return;
    }
    isQuitFlag = true;
    //是否已进入房间
    if (currentStatus == StatusType.enter_room) {
        qavSdk.ExitRoom();
    }
    //停止sdk
    stopContext();
}

//qavsdk登录
function qavSdkLogin() {
    log.info('start qavSdk login');
    qavSdk.Login(loginInfo.sdkAppID, loginInfo.accountType, loginInfo.sdkAppID, loginInfo.identifier, loginInfo.userSig);
    log.info('after qavSdk login');
}

//启动qavsdk
function startContext() {
    log.info('start StartContext');
    qavSdk.StartContext(loginInfo.sdkAppID, loginInfo.accountType, loginInfo.sdkAppID, loginInfo.identifier, loginInfo.userSig);
    log.info('after StartContext');
}

//停止qavsdk
function stopContext() {
    log.info('start StopContext');
    qavSdk.StopContext();
    log.info('after StopContext');
}

//判断str是否只包含数字
function validNumber(str) {
    str = str.toString();
    return str.match(/(^\d+$)/g);
}


