package za.co.entelect.jbootcamp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class Permission implements java.io.Serializable {

    @Id
    @Column(name="permission_id")
    private int permissionId;

    private String permission;

    public Permission() {}

    public Permission(int permissionId, String permission) {
        this.permissionId = permissionId;
        this.permission = permission;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
