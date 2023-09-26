package com.football.football.service;

import com.football.football.dto.GroupDTO;
import com.football.football.dto.TeamDTO;
import com.football.football.model.Team;
import com.football.football.repository.TeamRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public Long save(TeamDTO vO) throws Exception {
        Team bean = new Team();
        try {
            List<TeamDTO> teamDTOS = this.getAllTeam();
            if(!teamDTOS.isEmpty()){
                Assert.isTrue(teamDTOS.size()<16,"You cannot Add new team because total team is equal or greater than 16");
            }
            BeanUtils.copyProperties(vO, bean);
            bean = teamRepository.save(bean);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return bean.getId();
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    public void update(Long id, TeamDTO vO) {
        Team bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bean.setId(id);
        teamRepository.save(bean);
    }

    public TeamDTO getById(Long id) {
        Team original = requireOne(id);
        return toDTO(original);
    }

    public List<TeamDTO> getAllTeam() {
        List<Team> original = teamRepository.findAll();
        return toDTOList(original);
    }

    private List<TeamDTO> toDTOList(List<Team> original) {
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for(Team team: original){
            TeamDTO bean = new TeamDTO();
            BeanUtils.copyProperties(team, bean);
            teamDTOS.add(bean);
        }

        return teamDTOS;
    }

    private TeamDTO toDTO(Team original) {
        TeamDTO bean = new TeamDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Team requireOne(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }


    public List<GroupDTO> makeGroup() throws Exception{
        List<Team> original = teamRepository.findAll();
        try {
            if(!original.isEmpty()){
                Assert.isTrue(original.size()==16,"Cannot group because invalid number of teams");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        List<GroupDTO> groupDTOS = new ArrayList<>();
        Random randomGenerator = new Random();
        for(int i=0;i<4;i++){
            GroupDTO groupDTO = new GroupDTO();
            List<TeamDTO> teamDTOS = new ArrayList<>();
            for(int j=0; j<4;j++){
                int index = randomGenerator.nextInt(original.size());
                teamDTOS.add(toDTO(original.get(index)));
                original.remove(index);
            }
            groupDTO.setTeamDTOList(teamDTOS);
            groupDTOS.add(groupDTO);
        }
        return groupDTOS;
    }
}
