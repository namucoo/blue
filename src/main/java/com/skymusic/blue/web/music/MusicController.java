package com.skymusic.blue.web.music;


import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skymusic.blue.entity.Music;
import com.skymusic.blue.entity.User;
import com.skymusic.blue.service.account.ShiroDbRealm.ShiroUser;
import com.skymusic.blue.service.music.MusicService;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;

/**
 * Music管理的Controller, 使用Restful风格的Urls:
 * 
 * List page     : GET /music/
 * Create page   : GET /music/create
 * Create action : POST /music/create
 * Update page   : GET /music/update/{id}
 * Update action : POST /music/update
 * Delete action : GET /music/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/music")
public class MusicController {

	private static final int PAGE_SIZE = 3;

	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("title", "标题");
	}

	@Autowired
	private MusicService musicService;

//	@RequestMapping(value = "")
//	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
//			@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request) {
//		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
//
//		Page<Music> musics = musicService.getUserMusic(userId, searchParams, pageNumber, PAGE_SIZE, sortType);
//
//		model.addAttribute("tasks", musics);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
//		// 将搜索条件编码成字符串，用于排序，分页的URL
//		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
//
//		return "music/musicList";
//	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("music", new Music());
		model.addAttribute("action", "create");
		return "music/musicForm";
	}

//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	public String create(@Valid Music newMusic, RedirectAttributes redirectAttributes) {
//		User user = new User(getCurrentUserId());
//		newMusic.set(user);
//
//		musicService.saveMusic(newMusic);
//		redirectAttributes.addFlashAttribute("message", "创建音乐成功");
//		return "redirect:/music/";
//	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("music", musicService.getMusic(id));
		model.addAttribute("action", "update");
		return "music/musicForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadMusic") Music music, RedirectAttributes redirectAttributes) {
		musicService.saveMusic(music);
		redirectAttributes.addFlashAttribute("message", "更新任务成功");
		return "redirect:/music/";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		musicService.deleteMusic(id);
		redirectAttributes.addFlashAttribute("message", "删除任务成功");
		return "redirect:/music/";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Music对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
	 */
	@ModelAttribute("preloadMusic")
	public Music getMusic(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return musicService.getMusic(id);
		}
		return null;
	}

	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
//public class MusicController {
//
//}
