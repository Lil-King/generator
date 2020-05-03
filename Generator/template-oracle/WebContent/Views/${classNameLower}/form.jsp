<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w10per">企业名称</th>
			<td class="w35per">
				<input type="text" name="qymc" class="inp_t" value="${model.qymc}" data-val="true" data-val-required="请输入企业名称！" />
				<span class="field-validation-error" data-valmsg-for="qymc"
						data-valmsg-replace="true"><span for="qymc"
							generated="true" class="dn">请输入企业名称！</span></span>
			</td>
			<th class="w10per">负责人</th>
			<td>
				<input type="text" name="fzr" class="inp_t" value="${model.fzr}" />
			</td>
		</tr>
		<tr>
			<th>业务咨询</th>
			<td>
				<input type="text" name="ywzxsj" class="inp_t" value="${model.ywzxsj}" />
			</td>
			<th>投诉建议</th>
			<td>
				<input type="text" name="tsjysj" class="inp_t" value="${model.tsjysj}" />
			</td>
		</tr>
		<tr>
			<th>安装</th>
			<td>
				<input type="text" name="azsj" class="inp_t" value="${model.azsj}" />
			</td>
			<th>维修</th>
			<td>
				<input type="text" name="wxsj" class="inp_t" value="${model.wxsj}" />
			</td>
		</tr>
		<tr>
			<th>拆/移机</th>
			<td>
				<input type="text" name="cyjsj" class="inp_t" value="${model.cyjsj}" />
			</td>
			<th>退/换机</th>
			<td>
				<input type="text" name="thjsj" class="inp_t" value="${model.thjsj}" />
			</td>
		</tr>
		<tr>
			<th>鉴定/监测</th>
			<td>
				<input type="text" name="jdjcsj" class="inp_t" value="${model.jdjcsj}" />
			</td>
			<th>其他</th>
			<td>
				<input type="text" name="qtsj" class="inp_t" value="${model.qtsj}" />
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td class="btn_area" colspan="2"><span class="btn btn_pub">
					<input type="submit" value="保存" />
			</span><span class="ml10 btn btn_base"> <input type="button"
					id="btn_pclose" value="取消">
			</span></td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript">
	function backToList(result) {
		if (result.flag) {
			successMsg(result.msg, function() {
				var opener = art.dialog.open.origin;
				opener.$('#spec_form').submit();
				closeDialog();
			});
		} else {
			errorMsg(result.msg);
		}
	}

	function showError(result) {
		errorMsg(result.msg);
	}
	
</script>