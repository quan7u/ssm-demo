//加载评论
function loadComment(weiboId){
    if($('#'+weiboId).children().length<=0){
    var commentAction = "queryComment.action?weiboId=" + weiboId;
    $.ajax({
        type: 'GET',
        url: commentAction,
        contentType: 'application/json;charset=utf-8',
        dataType: 'json',
        success:function(data) {
            for(var i in data){
                var com = '<div class="comment-show-con clearfix ">' +
                '<div class="comment-show-con-img pull-left ">' +
                //头像
                '<img class="img-circle " style="height: 50px; width: 50px;"' +
                'src="/imgUpload/'+ data[i].user.face + '"></div>' +
                '<div class="comment-show-con-list pull-left clearfix ">' +
                '<div class="pl-text clearfix ">' +
                //昵称
                '<a href="# " class="comment-size-name ">'+ data[i].user.nickname +'</a>' +
                '<input type="hidden" class="comment-size-userId" value="'+ data[i].userId +'">'+
                '<input type="hidden" class="comment-size-commentId" value="'+ data[i].commentId +'">'+
                //内容
                '<span class="my-pl-con ">:&nbsp; '+ data[i].commentContent +'</span></div>' +
                '<div class="date-dz ">'+
                //时间
                '<span class="date-dz-left pull-left comment-time ">'+ data[i].time +'</span>' +
                '<div class="date-dz-right pull-right comment-pl-block ">' +
                //回复
                '<a href="javascript:; " class="date-dz-pl pl-hf hf-con-block pull-left ">回复</a>' +
                '<span class="pull-left date-dz-line ">|</span>' +
                '<a href="javascript:; " class="date-dz-z pull-left ">' +
                //赞
                '<i class="date-dz-z-click-red "></i>赞 (<i class="z-num ">666</i>)</a>' +
                '</div></div><div class="hf-list-con " style="text-align: left;" id="'+ data[i].commentId +'">';
                if(data[i].countReply == 0) {
                	com = com + '</div></div></div>';
                } else {
                	com = com + '<a href="singleWeibo.action?weiboId='+ weiboId +'" style="color: #987">共'+ data[i].countReply +'条回复</a>'+
                    			'</div></div></div>';
                }
            $('#'+weiboId).prepend(com);
                }
            }
        });
    }
}


// <!--textarea高度自适应-->
$(function() {
    $('.content').flexText();
});
// <!--textarea限制字数-->
function keyUP(t) {
    var len = $(t).val().length;
    if (len > 139) {
        $(t).val($(t).val().substring(0, 140));
    }
}

// 显示评论列表 分页 每页十条记录


// <!--点击评论创建评论条-->
$('.commentAll').on('click', '.plBtn', function() {
	var face = $("#face").val();
	var nickname = $("#nickname").val();
	var userId = $("#userId").val();
	var weiboId = $(this).parents('.reviewArea ').find('.weiboId').val();
    console.log(weiboId);
    var myDate = new Date();
    //获取当前年
    var year = myDate.getFullYear();
    //获取当前月
    var month = myDate.getMonth() + 1;
    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours(); //获取当前小时数(0-23)
    var m = myDate.getMinutes(); //获取当前分钟数(0-59)
    if (m < 10) m = '0' + m;
    var s = myDate.getSeconds();
    if (s < 10) s = '0' + s;
    var now = year + '-' + month + "-" + date + " " + h + ':' + m + ":" + s;
    //获取输入内容
    var oSize = $(this).siblings('.flex-text-wrap').find('.comment-input').val();
    //动态创建评论模块
    oHtml = '<div class="comment-show-con clearfix">' +
            '<div class="comment-show-con-img pull-left">' +
            //本用户 头像
            '<img class="img-circle " style="height: 50px; width: 50px;" src="/imgUpload/' + face + '" alt=""></div>' +
            '<div class="comment-show-con-list pull-left clearfix">' +
            '<div class="pl-text clearfix">' +
            // 本用户 昵称
            '<a href="#" class="comment-size-name">' + nickname + '</a>' +
            '<span class="my-pl-con">&nbsp;' + oSize + '</span>' +
            '</div> <div class="date-dz">' +
            '<span class="date-dz-left pull-left comment-time">' + now + '</span>' +
            '<div class="date-dz-right pull-right comment-pl-block">' +
            '<a href="javascript:;" class="removeBlock">删除</a>' +
            '<a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>' +
            '<span class="pull-left date-dz-line">|</span>' +
            '<a href="javascript:;" class="date-dz-z pull-left">' +
            '<i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a>' +
            '</div> </div><div class="hf-list-con"></div></div> </div>';
    if (oSize.replace(/(^\s*)|(\s*$)/g, "") != '') {
        $(this).parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
        $(this).siblings('.flex-text-wrap').find('.comment-input').prop('value', '').siblings('pre').find('span').text('');
        var json = {
        	"userId":userId,
        	"weiboId":weiboId,
        	"commentTime":now,
        	"commentContent":oSize
        };
        $.ajax({
        	type: 'post',
        	url: "comment.action",
        	contentType: 'application/json;charset=utf-8',
        	data: JSON.stringify(json),
        	success:function(data) {
        	}
        });
    }
});
// <!--点击回复动态创建回复块-->
$('.comment-show').on('click', '.pl-hf', function() {
    //获取回复人的名字
    var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
    //回复@
    var fhN = '回复@' + fhName + ':';
    //var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
    var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
    //显示回复
    if ($(this).is('.hf-con-block')) {
        $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
        $(this).removeClass('hf-con-block');
        $('.content').flexText();
        $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding', '6px 15px');
        //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
        //input框自动聚焦
        $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
    } else {
        $(this).addClass('hf-con-block');
        $(this).parents('.date-dz-right').siblings('.hf-con').remove();
    }
});
// <!--评论回复块创建-->
$('.comment-show').on('click', '.hf-pl', function() {
    var oThis = $(this);
    var myDate = new Date();
    //获取当前年
    var year = myDate.getFullYear();
    //获取当前月
    var month = myDate.getMonth() + 1;
    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours(); //获取当前小时数(0-23)
    var m = myDate.getMinutes(); //获取当前分钟数(0-59)
    if (m < 10) m = '0' + m;
    var s = myDate.getSeconds();
    if (s < 10) s = '0' + s;
    var now = year + '-' + month + "-" + date + " " + h + ':' + m + ":" + s;
    //获取输入内容
    var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();
    console.log(oHfVal)
    var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
    var oAllVal = '回复@' + oHfName;
    if (oHfVal.replace(/^ +| +$/g, '') == '' || oHfVal == oAllVal) {

    } else {
        var content;
        $.getJSON("/weibo/json/pl.json", function(data) {
            var oAt = '';
            var oHf = '';
            $.each(data, function(n, v) {
                delete v.hfContent;
                delete v.atName;
                var arr;
                var ohfNameArr;
                if (oHfVal.indexOf("@") == -1) {
                    data['atName'] = '';
                    data['hfContent'] = oHfVal;
                } else {
                    arr = oHfVal.split(':');
                    ohfNameArr = arr[0].split('@');
                    console.log(ohfNameArr);

                    data['hfContent'] = arr[1];
                    data['atName'] = ohfNameArr[1];
                }

                if (data.atName == '') {
                    oAt = data.hfContent;
                } else {
                    oAt = ' 回复 <a href="#" class="atName">@' + data.atName + '</a> : ' + data.hfContent;
                    content=data.hfContent;
                }
                oHf = data.hfName;
            });

            var nickname = $("#nickname").val();            
            //comment_id
            var commentId = oThis.parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-commentId').val();
            console.log(commentId);
            //from_id
            var fromId = $("#userId").val();
            //to_id
            var toId = oThis.parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-userId').val();
            console.log(content);
            //content
            //time
            var time = now;
            var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix">'+
                        //昵称
                        '<a href="#" class="comment-size-name">'+ nickname +'</a>'+
                        '<input type="hidden" class="comment-size-userId" value="'+ fromId +'">'+
                        '<input type="hidden" class="comment-size-commentId" value="'+ commentId +'">'+
                        //内容
                        '<span class="my-pl-con">' + oAt + '</span></div><div class="date-dz">'+
                        //时间
                        '<span class="date-dz-left pull-left comment-time">' + now + '</span>'+
                        '<div class="date-dz-right pull-right comment-pl-block">'+
                        '<a href="javascript:;" class="removeBlock">删除</a>'+
                        '<a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>'+
                        '<span class="pull-left date-dz-line">|</span>'+
                        '<a href="javascript:;" class="date-dz-z pull-left">'+
                        '<i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a></div> </div></div>';
            oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display', 'block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
            var json = {
            "commentId":commentId,
            "fromId":fromId,
            "toId":toId,
            "content":content,
            "time":time
            };
            $.ajax({
                type: 'post',
                url: "reply.action",
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(json),
                success:function(data) {
                }
            });

        });
    }
});
// <!--删除评论块-->
$('.commentAll').on('click', '.removeBlock', function() {
    var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
    if (oT.siblings('.all-pl-con').length >= 1) {
        oT.remove();
    } else {
        $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display', 'none')
        oT.remove();
    }
    $(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();

})
// <!--点赞-->
$('.comment-show').on('click', '.date-dz-z', function() {
    var zNum = $(this).find('.z-num').html();
    if ($(this).is('.date-dz-z-click')) {
        zNum--;
        $(this).removeClass('date-dz-z-click red');
        $(this).find('.z-num').html(zNum);
        $(this).find('.date-dz-z-click-red').removeClass('red');
    } else {
        zNum++;
        $(this).addClass('date-dz-z-click');
        $(this).find('.z-num').html(zNum);
        $(this).find('.date-dz-z-click-red').addClass('red');
    }
})
//加载评论下的回复
// var replyAction = "queryReply.action?commentId=" + data[i].commentId;
//  $.ajax({
// type: 'GET',
// url: replyAction,
// contentType: 'application/json;charset=utf-8',
// dataType: 'json',
// success:function(data) {
//     for(var r in data){
//     var Reply = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix">'+
//                 //昵称
//                 '<a href="#" class="comment-size-name">'+ data[j].user.nickname +': </a>'+
//                 //内容
//                 '<span class="my-pl-con">' + 'hehe' + '</span></div><div class="date-dz">'+
//                 //时间
//                 '<span class="date-dz-left pull-left comment-time">' + '2018-6-3 12:07' + '</span>'+
//                 '<div class="date-dz-right pull-right comment-pl-block">'+
//                 '<a href="javascript:;" class="removeBlock">删除</a>'+
//                 '<a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>'+
//                 '<span class="pull-left date-dz-line">|</span>'+
//                 '<a href="javascript:;" class="date-dz-z pull-left">'+
//                 '<i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a></div> </div></div>';
//                 $('#'+weiboId).find('#'+data[i].commentId).prepend(Reply);
//                 }
//             }
//         });