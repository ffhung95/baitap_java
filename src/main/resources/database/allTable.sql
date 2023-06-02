
create database  btl_qlcf;
use btl_qlcf;

create table admin(
                      maadmin int primary key auto_increment,
                      taikhoan varchar(215)  UNIQUE not null,
                      matkhau varchar(215) not null,
                      hoten varchar(215) not null,
                      sdt varchar(11) not null,
                      avatar blob
);

create table nhanvien(
                         manv int primary key auto_increment ,
                         hotennv varchar(215) not null,
                         taikhoan varchar(215) UNIQUE not null,
                         matkhau varchar(215) not null,
                         sdt varchar(11) not null,
                         ngayvaolam date check(ngayvaolam<=sysdate()),
                         chucvu varchar(215) not null,
                         luong int not null
);

create table loaihang(
                         maloaihang int primary key not null auto_increment ,
                         tenloaihang varchar(215) not null
);

create table hanghoa(
                        mahanghoa int primary key not null auto_increment ,
                        tenhanghoa varchar(215)  UNIQUE not null,
                        giahanghoa double not null ,
                        soluong int not null,
                        maloaihang int ,
                        maadmin int ,
                        anhhanghoa blob
);

alter table hanghoa
    add foreign key (maloaihang) REFERENCES loaihang(maloaihang);
alter table hanghoa
    add foreign key (maadmin) REFERENCES admin(maadmin);

create table ban(
                    maban int primary key auto_increment ,
                    name varchar(45) not null ,
                    status varchar(45) NOT NULL
                        DEFAULT 'free' COMMENT 'free-Trống\nserving-Đang phục vụ\nreserving-Đặt trước'
);
CREATE TABLE hoadon(
                       MAHD int auto_increment PRIMARY KEY AUTO_INCREMENT,
                       NGAYINHD TIMESTAMP NOT NULL ,
    -- DEFAULT CURRENT_TIMESTAMP
                       maban int not null,
                       TONGTIEN FLOAT NOT NULL
);
alter table hoadon
    add foreign key (maban) REFERENCES ban(maban);


CREATE TABLE chitiethoadon(
                              ma_cthd int primary key auto_increment,
                              mahd int not null,
                              manv int not null,
                              mamon int not null,
                              SOLUONG INT NOT NULL,
                              THANHTIEN FLOAT,
                              GHICHU VARCHAR(200)
);
alter table chitiethoadon
    add foreign key (mahd) REFERENCES hoadon(mahd);

alter table CHITIETHOADON
    add foreign key (manv) REFERENCES nhanvien(manv);
alter table CHITIETHOADON
    add foreign key (mamon) REFERENCES hanghoa(mahanghoa);

create table phienlamviec(
                             maphienlamviec int  not null DEFAULT 1  primary key,
                             manv int ,
                             trangthai varchar(45) UNIQUE NOT NULL
                                                          DEFAULT 'serving' COMMENT 'free-Chua hooạt động\nserving-Đang hoạt động'
);
alter table phienlamviec
    add foreign key (manv) REFERENCES nhanvien(manv);

create table dathang(
                        madathang int primary key  auto_increment  ,
                        maban int not null ,
                        maphienlamviec int not null,
                        mahanghoa int  not null,
                        soluong int  not null,
                        thanhtien float
);
alter table dathang
    add foreign key (maphienlamviec) REFERENCES phienlamviec(maphienlamviec);
alter table dathang
    add foreign key (maban) REFERENCES ban(maban);
alter table dathang
    add foreign key (mahanghoa) REFERENCES hanghoa(mahanghoa);





