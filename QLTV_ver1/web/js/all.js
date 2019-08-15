function xacNhan() {
    var re = confirm("Bạn có muốn tiếp tục không ?")
    if (re == true) {
        return true;
    } else
        return false;
}
//function search_check_theloai() {
//    if (document.getElementById('mathl').value == '') {
//        alert('Bạn chưa nhập mã thể loại cần tìm');
//        return false;
//    } else {
//        return true;
//    }
//}
//function kiemtra_form_themtheloai() {
//    var user = document.getElementById('tenTL').value;
//    var ghichu = document.getElementById('ghiChu').value;
//    if (user == '') {
//        alert('Bạn chưa nhập tên thể loại');
//        return false;
//    } else {
//        if (ghichu == '') {
//            alert('Bạn chưa nhập ghi chú');
//            return false;
//        } else
//            return true;
//    }
//}
//function kiemtra_form_suatheloai() {
//
//    if (confirm("Bạn có muốn tiếp tục không ?")) {
//
//        var user = document.getElementById('tenTL').value;
//        var ghichu = document.getElementById('ghiChu').value;
//        if (user == '') {
//            alert('Bạn chưa nhập tên thể loại');
//            return false;
//        } else {
//            if (ghichu == '') {
//                alert('Bạn chưa nhập ghi chú');
//                return false;
//            } else
//                return true;
//        }
//    } else {
//        return false;
//    }
//}
//function search_check_tailieu() {
//    if (document.getElementById('matl').value == '') {
//        alert('Bạn chưa nhập mã tài liệu cần tìm');
//        return false;
//    } else {
//
//        return true;
//    }
//}
//function search_check_nhanvien() {
//    if (document.getElementById('manv').value == '') {
//        alert('Bạn chưa nhập mã nhân viên cần tìm');
//        return false;
//    } else {
//
//        return true;
//    }
//}
//function kiemtra_form_themnhanvien() {
//    var hoten = document.getElementById('hoten').value;
//    var taikhoan = document.getElementById('taikhoan').value;
//    var matkhau = document.getElementById('matkhau').value;
//
//    if (hoten == '') {
//        alert('Bạn chưa nhập họ tên nhân viên');
//        return false;
//    } else {
//        if (taikhoan == '') {
//            alert('Bạn chưa nhập tên tài khoản');
//            return false;
//        } else {
//            if (matkhau == '') {
//                alert('Bạn chưa nhập mật khẩu');
//                return false;
//            } else
//                return true;
//        }
//
//    }
//}
//function kiemtra_form_suanhanvien() {
//    var hoten = document.getElementById('hoten').value;
//    var taikhoan = document.getElementById('taikhoan').value;
//    var matkhau = document.getElementById('matkhau').value;
//
//    if (confirm("Bạn có muốn tiếp tục không ?")) {
//        if (hoten == '') {
//            alert('Bạn chưa nhập họ tên nhân viên');
//            return false;
//        } else {
//            if (taikhoan == '') {
//                alert('Bạn chưa nhập tên tài khoản');
//                return false;
//            } else {
//                if (matkhau == '') {
//                    alert('Bạn chưa nhập mật khẩu');
//                    return false;
//                } else
//                    return true;
//            }
//
//        }
//    } else
//        return false;
//}
//function search_check_docgia() {
//    if (document.getElementById('madg').value == '') {
//        alert('Bạn chưa nhập mã độc giả cần tìm');
//        return false;
//    } else {
//
//        return true;
//    }
//}
//function check_muonsach_madocgia() {
//    var madg = document.getElementById('madg').value;
//    if (madg == '') {
//        alert('Bạn chưa nhâp mã độc giả');
//        return false;
//    } else
//        return true;
//}
function selectTL_muonsach_themtailieu(obj) {
    var matl = obj.value;
    window.location.replace("muonsach_themtailieu.jsp?matl=" + matl + "");
}
function checkAdd_muonsach_themtailieu() {
    var matl = document.getElementById('tentl').value;
    var slcon = document.getElementById('slcon').value;
    if (matl == '') {
        alert('Bạn chưa chọn tài liệu');
        return false;
    } else {
        if (slcon == 0) {
            alert('Tài Liệu này đã hết. Vui lòng chọn tài liệu khác');
            return false;
        } else
            return true;
    }
}
function selectTL_muonsach_suatailieu(obj) {
    var matl = obj.value;
    window.location.replace("muonsach_themtailieu.jsp?matl=" + matl + "");
}
function checkAdd_muonsach_suatailieu() {
    var matl = document.getElementById('tentl').value;
    var slcon = document.getElementById('slcon').value;
    if (matl == '') {
        alert('Bạn chưa chọn tài liệu');
        return false;
    } else {
        if (slcon == 0) {
            alert('Tài Liệu này đã hết. Vui lòng chọn tài liệu khác');
            return false;
        } else
            return true;
    }
}
//function search_check_trasach_madocgia() {
//    if (document.getElementById('mapm').value == '') {
//        alert('Bạn chưa nhập mã phiếu mượn cần tìm');
//        return false;
//    } else {
//
//        return true;
//    }
//}
function selectTT_trasach(obj) {
    var tt = obj.value;
    window.location.replace("trangchu_trasach.jsp?tt=" + tt + "");
}
function selectTT_main_tk_bc(obj) {
    var tt = obj.value;
    window.location.replace("thongke_baocao.jsp?tt=" + tt + "");
}

