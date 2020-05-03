<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="csc/systemconfig/update.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-success="showError" novalidate="novalidate">
			<input type="hidden" name="id" value="${model.id}" />
			<%@ include file="form.jsp"%>
		</form>	
	</div>
</gd:PopLayout> 