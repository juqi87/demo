/*
window.alert = newalert;
function newalert(alertMsg){
    $('#alertMsg').html(alertMsg);
    $('#alertMsgDiv').modal('show');
}
*/

var oldAlert = window.alert;
window.alert = newAlert;

//dialog选择器，页面标题，主题内容
function newAlert (msg) {
	$ele = $('#dialog2');
	$ele.find('.weui_dialog_bd').html(msg);
	$ele.show();
	$ele.find('.weui_btn_dialog').one('click',function(){
		$ele.hide();
	});
}