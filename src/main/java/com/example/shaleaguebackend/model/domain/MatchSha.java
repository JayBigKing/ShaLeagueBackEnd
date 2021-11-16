package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("MatchSha")
@ApiModel(value="MatchSha对象", description="")
public class MatchSha extends Model<MatchSha> {

    private static final long serialVersionUID = 1L;

    @TableId("Mid")
    private Long Mid;

    @TableField("Mdate")
    private LocalDateTime Mdate;

    @TableField("Sid")
    private Long Sid;

    @TableField("Pid")
    private Long Pid;


    @Override
    protected Serializable pkVal() {
        return this.Mid;
    }

}
