package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Role")
@ApiModel(value="Role对象", description="")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @TableId("Rid")
    private Long Rid;

    @TableField("Mid")
    private Long Mid;

    @TableField("Pid")
    private Long Pid;

    @TableField("Sid")
    private Long Sid;

    @TableField("RTheRole")
    private Integer RTheRole;

    @TableField("Rresult")
    private Boolean Rresult;


    @Override
    protected Serializable pkVal() {
        return this.Rid;
    }

}
