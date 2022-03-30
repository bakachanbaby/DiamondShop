<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liên hệ</title>
</head>
<body>
<hr class="soften">
<div class="well well-small">
    <h1>Visit us</h1>
    <hr class="soften"/>
    <div class="row-fluid">
        <div class="span8 relative">
            <iframe style="width: 100%; height: 350px" frameborder="0"
                    scrolling="no" marginheight="0" marginwidth="0"
                    src="http://maps.google.co.uk/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Newbury+Street,+Boston,+MA,+United+States&amp;aq=1&amp;oq=NewBoston,+MA,+United+States&amp;sll=42.347238,-71.084011&amp;sspn=0.014099,0.033023&amp;ie=UTF8&amp;hq=Newbury+Street,+Boston,+MA,+United+States&amp;t=m&amp;ll=42.348994,-71.088248&amp;spn=0.001388,0.006276&amp;z=18&amp;iwloc=A&amp;output=embed"></iframe>
        </div>
        <div class="span4">
            <h4>Email cho chúng tôi</h4>
            <form:form action="dang-ky" method="POST" modelAttribute="user">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Email</label>
                        <div class="controls">
                            <input type="text" placeholder="Nhập email" class="input-xlarge"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Họ và tên</label>
                        <div class="controls">
                            <input type="text" placeholder="Nhập họ tên" class="input-xlarge"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Lời nhắn <sup>*</sup></label>
                        <div class="controls">
                            <textarea rows="3" id="textarea" class="input-xlarge" placeholder="Gửi lời nhắn"></textarea>
                        </div>
                    </div>
                    <div class="controls">
                        <button class="shopBtn" type="submit">Gửi email</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>