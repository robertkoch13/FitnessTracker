package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="permission")
public class Permission implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Permission{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
