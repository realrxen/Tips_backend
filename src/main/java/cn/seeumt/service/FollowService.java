package cn.seeumt.service;

import cn.seeumt.dataobject.Follow;
import cn.seeumt.vo.ResultVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-02-10
 */
public interface FollowService extends IService<Follow> {
    List<Follow> getAllIdol(String userId);

    ResultVO add(String userId, String idolId);

    ResultVO isIdol(String idolId, String userId);
}
