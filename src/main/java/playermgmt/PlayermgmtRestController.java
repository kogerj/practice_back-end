package playermgmt;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import playermgmt.SpringLoggingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/playermgmt")
class PlayermgmtRestController{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    String index(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        new SpringLoggingHelper().helpMethod();
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET, value="/info")
	String instructions()throws Exception {
    return "/playermgmt/players/allplayers  **  /playermgmt/players/allbannedplayers  ** /playermgmt/players/search  ** /playermgmt/playerslist/{offset}/{limit}  **  /playermgmt/players/{id}  **  /playermgmt/nickname/{nickname}  **  ";
	}
  
  @RequestMapping(method = RequestMethod.GET, value="/players/allplayers")
	Object ReadAllPlayers(HttpServletResponse response)throws Exception {
		Object result = PlayermgmtData.ReadAllPlayersFromDB();
		if (result==null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}else{
			return result;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value="/players/allbannedplayers")
	Object ReadAllBannedPlayers(HttpServletResponse response)throws Exception {
		Object result = PlayermgmtData.ReadAllBannedPlayersFromDB();
		if (result==null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}else{
			return result;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value="/playerslist/{offset}/{limit}")
	Object ReadAllPlayersByOffset(@PathVariable int offset, @PathVariable int limit)throws Exception {
    return PlayermgmtData.ReadPlayersFromDB(offset, limit);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/players/{id}")
	Object ReadPlayerId(@PathVariable int id, HttpServletResponse response) throws Exception{
				Object result = PlayermgmtData.ReadPlayerfromDB(id);
		if (result==null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}else{
			return result;
		}
	}

	@RequestMapping(method =RequestMethod.GET, value = "/nickname/{nickname}")
	Object SearchPlayersByNickname(@PathVariable String nickname)throws Exception{
	  return PlayermgmtData.SearchByNickname(nickname);
	}

	@RequestMapping(method =RequestMethod.POST, value = "/players/search")
	@ResponseBody
	public Object SearchPlayers(@RequestBody String searchQuery, HttpServletResponse response)throws Exception{
		Object result = PlayermgmtData.SearchByField(searchQuery);
		if (result==null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}else if(result.toString().length()==2) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}else{
			return result;
		}
	  
	}

	@RequestMapping(method =RequestMethod.POST, value = "/players/banstatus")
	@ResponseBody
	public Object ChangeBanStatus(@RequestBody String banQuery, HttpServletResponse response)throws Exception{
		try {
			Object result = PlayermgmtPlayerActions.ChangeBanStatus(banQuery);
			if (result == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				logger.error("Bad request", result);
				return null;
			}else{
				return result;
			}
			
		} catch (Exception e) {
			logger.warn(e.toString());
			return null;
		}

		
	}

	@RequestMapping(method =RequestMethod.POST, value = "/login")
	Object MgmtLogin(@RequestBody String loginRequest, HttpServletResponse response)throws Exception{
	  Object result = PlayermgmtAdminLogin.AdminLogin(loginRequest);
		if (result==null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}else{
			return result;
		}
	}
	
}