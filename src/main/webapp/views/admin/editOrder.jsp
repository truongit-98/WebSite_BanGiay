<%-- 
    Document   : editOrder
    Created on : Jun 1, 2020, 9:18:30 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/shared/admin/head.jsp" %>
    </head>

    <body class="no-skin">
        <%@include file="/shared/admin/header.jsp" %>
        <script type="text/javascript">
            try {
                ace.settings.check('navbar', 'fixed')
            } catch (e) {
            }
        </script>
        <%@include file="/shared/admin/sidebar.jsp" %>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="page-content">
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="widget-box">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <h4 class="widget-title lighter">Edit Order</h4>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div id="fuelux-wizard-container">
                                        <div class="fulex-wizad-container">
                                            <div class="step-pane active" data-step="1">
                                                <form style="width: 60%; margin: 30px" action="/WebSite_BanGiay/admin/orders/${order.maDH}" method="POST">
                                                    <div class="form-group">
                                                        <label for="">Mã ĐH</label>
                                                        <input type="text" name="maDH" value="${order.maDH}" class="form-control" id="" readonly aria-describedby="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Khách hàng</label>
                                                        <input type="text" name="hoTen" value="${order.hoTen}" min="16" class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Email</label>
                                                        <input type="email" name="email" value="${order.email}" min="12" class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">SĐT</label>
                                                        <input type="text" name="sdt" value="${order.sdt}" min="10" max="10" class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Ngày Đặt</label>
                                                        <input type="date" name="NgayDatt"  value="<fmt:formatDate value="${order.ngayDat}" pattern="yyyy-MM-dd" />" class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Ngày Giao</label>
                                                        <input type="date" name="NgayGiaoo" value="<fmt:formatDate value="${order.ngayGiao}" pattern="yyyy-MM-dd" />"  class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Địa chỉ</label>
                                                        <input type="text" name="dcGiao" value="${order.dcGiao}" required class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Tổng tiền</label>
                                                        <input type="text" name="tongTien" value="${order.tongTien}" required class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Tình trạng</label>
                                                        <input type="text" name="tinhTrang" value="${order.tinhTrang}" required class="form-control" id="" placeholder="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="">Hình thức thanh toán</label>
                                                        <input type="text" name="thanhToan" value="${order.thanhToan}" required class="form-control" id="" placeholder="">
                                                    </div>
                                                    <button type="submit"  class="btn btn-primary">Cập nhật</button>
                                                </form>
                                            </div>
                                        </div>
                                        <hr />
                                    </div>                                      
                                </div><!-- /.widget-main -->
                            </div><!-- /.widget-body -->
                        </div>

                        <div id="modal-wizard" class="modal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div id="modal-wizard-container">
                                        <div class="modal-header">
                                            <ul class="steps">
                                                <li data-step="1" class="active">
                                                    <span class="step">1</span>
                                                    <span class="title">Validation states</span>
                                                </li>

                                                <li data-step="2">
                                                    <span class="step">2</span>
                                                    <span class="title">Alerts</span>
                                                </li>

                                                <li data-step="3">
                                                    <span class="step">3</span>
                                                    <span class="title">Payment Info</span>
                                                </li>

                                                <li data-step="4">
                                                    <span class="step">4</span>
                                                    <span class="title">Other Info</span>
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="modal-body step-content">
                                            <div class="step-pane active" data-step="1">
                                                <div class="center">
                                                    <h4 class="blue">Step 1</h4>
                                                </div>
                                            </div>

                                            <div class="step-pane" data-step="2">
                                                <div class="center">
                                                    <h4 class="blue">Step 2</h4>
                                                </div>
                                            </div>

                                            <div class="step-pane" data-step="3">
                                                <div class="center">
                                                    <h4 class="blue">Step 3</h4>
                                                </div>
                                            </div>

                                            <div class="step-pane" data-step="4">
                                                <div class="center">
                                                    <h4 class="blue">Step 4</h4>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="modal-footer wizard-actions">
                                        <button class="btn btn-sm btn-prev">
                                            <i class="ace-icon fa fa-arrow-left"></i>
                                            Prev
                                        </button>

                                        <button class="btn btn-success btn-sm btn-next" data-last="Finish">
                                            Next
                                            <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                        </button>

                                        <button class="btn btn-danger btn-sm pull-left" data-dismiss="modal">
                                            <i class="ace-icon fa fa-times"></i>
                                            Cancel
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>

    </div><!-- /.main-content -->
    <%@include file="/shared/admin/footer.jsp" %>

    <!-- inline scripts related to this page -->
    <script type="text/javascript">
        jQuery(function ($) {

            $('[data-rel=tooltip]').tooltip();

            $(".select2").css('width', '200px').select2({allowClear: true})
                    .on('change', function () {
                        $(this).closest('form').validate().element($(this));
                    });


            var $validation = false;
            $('#fuelux-wizard-container')
                    .ace_wizard({
                        //step: 2 //optional argument. wizard will jump to step "2" at first
                        //buttons: '.wizard-actions:eq(0)'
                    })
                    .on('actionclicked.fu.wizard', function (e, info) {
                        if (info.step == 1 && $validation) {
                            if (!$('#validation-form').valid())
                                e.preventDefault();
                        }
                    })
                    .on('finished.fu.wizard', function (e) {
                        bootbox.dialog({
                            message: "Thank you! Your information was successfully saved!",
                            buttons: {
                                "success": {
                                    "label": "OK",
                                    "className": "btn-sm btn-primary"
                                }
                            }
                        });
                    }).on('stepclick.fu.wizard', function (e) {
                //e.preventDefault();//this will prevent clicking and selecting steps
            });


            //jump to a step
            /**
             var wizard = $('#fuelux-wizard-container').data('fu.wizard')
             wizard.currentStep = 3;
             wizard.setState();
             */

            //determine selected step
            //wizard.selectedItem().step



            //hide or show the other form which requires validation
            //this is for demo only, you usullay want just one form in your application
            $('#skip-validation').removeAttr('checked').on('click', function () {
                $validation = this.checked;
                if (this.checked) {
                    $('#sample-form').hide();
                    $('#validation-form').removeClass('hide');
                } else {
                    $('#validation-form').addClass('hide');
                    $('#sample-form').show();
                }
            })



            //documentation : http://docs.jquery.com/Plugins/Validation/validate


            $.mask.definitions['~'] = '[+-]';
            $('#phone').mask('(999) 999-9999');

            jQuery.validator.addMethod("phone", function (value, element) {
                return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
            }, "Enter a valid phone number.");

            $('#validation-form').validate({
                errorElement: 'div',
                errorClass: 'help-block',
                focusInvalid: false,
                ignore: "",
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    password2: {
                        required: true,
                        minlength: 5,
                        equalTo: "#password"
                    },
                    name: {
                        required: true
                    },
                    phone: {
                        required: true,
                        phone: 'required'
                    },
                    url: {
                        required: true,
                        url: true
                    },
                    comment: {
                        required: true
                    },
                    state: {
                        required: true
                    },
                    platform: {
                        required: true
                    },
                    subscription: {
                        required: true
                    },
                    gender: {
                        required: true,
                    },
                    agree: {
                        required: true,
                    }
                },

                messages: {
                    email: {
                        required: "Please provide a valid email.",
                        email: "Please provide a valid email."
                    },
                    password: {
                        required: "Please specify a password.",
                        minlength: "Please specify a secure password."
                    },
                    state: "Please choose state",
                    subscription: "Please choose at least one option",
                    gender: "Please choose gender",
                    agree: "Please accept our policy"
                },

                highlight: function (e) {
                    $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
                },

                success: function (e) {
                    $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
                    $(e).remove();
                },

                errorPlacement: function (error, element) {
                    if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                        var controls = element.closest('div[class*="col-"]');
                        if (controls.find(':checkbox,:radio').length > 1)
                            controls.append(error);
                        else
                            error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                    } else if (element.is('.select2')) {
                        error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                    } else if (element.is('.chosen-select')) {
                        error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                    } else
                        error.insertAfter(element.parent());
                },

                submitHandler: function (form) {
                },
                invalidHandler: function (form) {
                }
            });




            $('#modal-wizard-container').ace_wizard();
            $('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');


            /**
             $('#date').datepicker({autoclose:true}).on('changeDate', function(ev) {
             $(this).closest('form').validate().element($(this));
             });
                 
             $('#mychosen').chosen().on('change', function(ev) {
             $(this).closest('form').validate().element($(this));
             });
             */


            $(document).one('ajaxloadstart.page', function (e) {
                //in ajax mode, remove remaining elements before leaving page
                $('[class*=select2]').remove();
            });
        })
    </script>
</body>
</html>
