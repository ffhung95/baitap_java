package utils;

public enum NhanVienStatus {
	FREE("free", "Chưa hoạt động"),
    SERVING("serving", "Đang hoạt động");
    private String id, name;
	NhanVienStatus(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static NhanVienStatus getById(String id) {
        for (NhanVienStatus e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return FREE;
    }
}
