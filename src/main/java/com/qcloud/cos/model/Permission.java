package com.qcloud.cos.model;

/**
 * Specifies constants defining an access permission, as granted to grantees in an
 * {@link AccessControlList}. Only a limited set of permission are available; each one is
 * represented as a value in this enumeration.
 */
public enum Permission {

    /**
     * Provides READ, WRITE permissions.
     * <p>
     * It does not convey additional rights and is provided only for convenience.
     * </p>
     */
    FullControl("FULL_CONTROL", "x-cos-grant-full-control"),

    /**
     * Grants permission to list the bucket when applied to a bucket. Grants permission to read
     * object data and/or metadata when applied to an object.
     */
    Read("READ", "x-cos-grant-read"),

    /**
     * Grants permission to create, overwrite, and delete any objects in the bucket.
     * <p>
     * This permission is not supported for objects.
     * </p>
     */
    Write("WRITE", "x-cos-grant-write"),

    /**
     * Grants permission to read the ACL for the applicable bucket or object.
     * <p>
     * The owner of a bucket or object always implicitly has this permission.
     * </p>
     */
    ReadAcp("READ_ACP", "x-cos-grant-read-acp"),

    /**
     * Gives permission to overwrite the ACP for the applicable bucket or
     * object.
     * <p>
     * The owner of a bucket or object always has this permission implicitly.
     * </p>
     * <p>
     * Granting this permission is equivalent to granting <code>FULL_CONTROL</code>because
     * the grant recipient can make any changes to the ACP.
     * </p>
     */
    WriteAcp("WRITE_ACP", "x-cos-grant-write-acp");


    private String permissionString;
    private String headerName;

    private Permission(String permissionString, String headerName) {
        this.permissionString = permissionString;
        this.headerName = headerName;
    }

    /**
     * Returns the name of the header used to grant this permission.
     */
    public String getHeaderName() {
        return headerName;
    }

    /**
     * Gets the string representation of this permission object as defined by Qcloud COS, eg.
     * <code>FULL_CONTROL</code>.
     * 
     * @return The string representation of this permission object as defined by Qcloud COS, eg.
     *         <code>FULL_CONTROL</code>.
     */
    public String toString() {
        return permissionString;
    }

    /**
     * Returns the {@link Permission} enumeration value representing the specified Qcloud COS Region
     * ID string. If specified string doesn't map to a known Qcloud COS Region, returns
     * <code>null</code>.
     * 
     * @param str A string representation of an Qcloud COS permission, eg. <code>FULL_CONTROL</code>
     * 
     * @return The {@link Permission} object represented by the given permission string, Returns
     *         <code>null</code> if the string isn't a valid representation of an Qcloud COS
     *         permission.
     */
    public static Permission parsePermission(String str) {
        for (Permission permission : Permission.values()) {
            if (permission.permissionString.equals(str)) {
                return permission;
            }
        }

        return null;
    }

}
